package com.ivanpuzyrev.rustorevkeducationcourse.presentation.appdetailsscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ivanpuzyrev.rustorevkeducationcourse.domain.AppRepository
import com.ivanpuzyrev.rustorevkeducationcourse.domain.Result
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.seconds

@HiltViewModel(assistedFactory = AppDetailsViewModel.Factory::class)
class AppDetailsViewModel @AssistedInject constructor(
    @Assisted appId: String,
    val appRepository: AppRepository
) : ViewModel() {

    private val _state = MutableStateFlow<AppDetailsState>(AppDetailsState.Loading)
    val state = _state.asStateFlow()

    private val _events = Channel<AppDetailsEvents>()
    val events = _events.receiveAsFlow()

    private var installJob: Job? = null

    init {
        loadApp(appId)
    }

    fun onInstallClick() {
        val currentState = _state.value
        if (currentState !is AppDetailsState.Content) return

        when (currentState.installState) {
            InstallState.Installed -> _state.update { currentState.copy( installState = InstallState.NotInstalled ) }

            is InstallState.Installing -> {
                installJob?.cancel()
                _state.update { currentState.copy(installState = InstallState.NotInstalled) }
            }

            InstallState.NotInstalled -> {
                installJob = viewModelScope.launch {
                    appRepository.installApp().collect { progress ->
                        if (progress != 100) {
                            _state.update { currentState.copy(installState = InstallState.Installing(progress)) }
                        } else {
                            _state.update { currentState.copy(installState = InstallState.Installed) }
                        }
                    }
                }
            }
        }
    }

    fun loadApp(appId: String) {
        viewModelScope.launch {
            _state.update { AppDetailsState.Loading }
            val appResultDef = async { appRepository.getAppById(appId) }
            val showCaseAppsResultDef = async { appRepository.getShowcaseApps(appId) }

            val appResult = appResultDef.await()
            val showCaseAppsResult = showCaseAppsResultDef.await()

            when {
                appResult is Result.Success && showCaseAppsResult is Result.Success ->
                    _state.update {
                        AppDetailsState.Content(
                            appResult.data,
                            showCaseAppsResult.data
                        )
                    }

                appResult is Result.Failure -> _state.update {
                    AppDetailsState.NetworkError(
                        appResult.error
                    )
                }

                showCaseAppsResult is Result.Failure -> _state.update {
                    AppDetailsState.NetworkError(
                        (showCaseAppsResult.error)
                    )
                }
            }
        }
    }

    fun clickLogo() {
        _events.trySend(AppDetailsEvents.LogoClicked)
    }


    @AssistedFactory
    interface Factory {
        fun create(@Assisted appId: String): AppDetailsViewModel
    }
}