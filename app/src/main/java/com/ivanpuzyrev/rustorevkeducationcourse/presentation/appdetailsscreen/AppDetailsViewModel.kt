package com.ivanpuzyrev.rustorevkeducationcourse.presentation.appdetailsscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ivanpuzyrev.rustorevkeducationcourse.domain.AppRepository
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel(assistedFactory = AppDetailsViewModel.Factory::class)
class AppDetailsViewModel @AssistedInject constructor(@Assisted appId: Int, val appRepository: AppRepository) : ViewModel() {

    private val _state = MutableStateFlow<AppDetailsState>(AppDetailsState.Loading)
    val state = _state.asStateFlow()

    private val _events = Channel<AppDetailsEvents>()
    val events = _events.receiveAsFlow()

    init {
        loadApp(appId)
    }

    fun loadApp(appId: Int) {
        viewModelScope.launch {
            _state.update { AppDetailsState.Loading }
            try {
                val appDef = async { appRepository.getAppById(appId) }
                val showCaseAppsDef = async { appRepository.getShowcaseApps() }
                _state.update { AppDetailsState.Content(appDef.await(), showCaseAppsDef.await()) }
            } catch (_: Exception) {
                _state.update { AppDetailsState.Error }
            }
        }
    }

    fun clickLogo() {
        _events.trySend(AppDetailsEvents.LogoClicked)
    }

    @AssistedFactory
    interface Factory {
        fun create(@Assisted appId: Int): AppDetailsViewModel
    }
}