package com.ivanpuzyrev.rustorevkeducationcourse.presentation.appdetailsscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ivanpuzyrev.rustorevkeducationcourse.data.AppRepository
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.seconds

class AppDetailsViewModel(appId: Int) : ViewModel() {

    private val _state = MutableStateFlow<AppDetailsState>(AppDetailsState.Loading)
    val state = _state.asStateFlow()

    private val _events = Channel<AppDetailsEvents>()
    val events = _events.receiveAsFlow()

    init {
        loadApp(appId)
    }

    private fun loadApp(appId: Int) {
        viewModelScope.launch {
            delay(1.seconds)
            _state.update {
                AppDetailsState.Content(AppRepository.getAppById(appId))
            }
        }
    }

    fun clickLogo() {
        _events.trySend(AppDetailsEvents.LogoClicked)
    }
}