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
        if (_state.value !is AppDetailsState.Content) return
        when ((_state.value as AppDetailsState.Content).installState) {
            InstallState.Installed -> _state.update { (it as AppDetailsState.Content).copy( installState = InstallState.NotInstalled ) }
            is InstallState.Installing -> {
                installJob?.cancel()
                _state.update { (it as AppDetailsState.Content).copy(installState = InstallState.NotInstalled) }
            }
            InstallState.NotInstalled -> {
                installJob = viewModelScope.launch {
                    emulateInstall()
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

    private suspend fun emulateInstall() {
        var progress = 0
        _state.update { (it as AppDetailsState.Content).copy( installState = InstallState.Installing(progress)) }
        delay(200.milliseconds)
        progress = (30..60).random()
        _state.update { (it as AppDetailsState.Content).copy( installState = InstallState.Installing(progress)) }
        delay(2.seconds)
        progress = (75..90).random()
        _state.update { (it as AppDetailsState.Content).copy( installState = InstallState.Installing(progress)) }
        delay(2.seconds)
        _state.update { (it as AppDetailsState.Content).copy( installState = InstallState.Installing(99)) }
        delay(2.seconds)
        _state.update { (it as AppDetailsState.Content).copy(installState = InstallState.Installed) }
    }

    @AssistedFactory
    interface Factory {
        fun create(@Assisted appId: String): AppDetailsViewModel
    }
}