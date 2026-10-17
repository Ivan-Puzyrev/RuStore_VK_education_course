package com.ivanpuzyrev.rustorevkeducationcourse.presentation.appdetailsscreen

import androidx.lifecycle.ViewModel
import com.ivanpuzyrev.rustorevkeducationcourse.data.AppRepository
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlin.time.Duration.Companion.seconds

class AppDetailsViewModel : ViewModel() {

    private val _state = MutableStateFlow<AppDetailsState>(AppDetailsState.Loading)
    val state = _state.asStateFlow()

    private val _events = Channel<AppDetailsEvents>()
    val events = _events.receiveAsFlow()

    suspend fun loadApp(appId: Int) {
        delay(1.seconds)
        _state.update {
            AppDetailsState.Content(AppRepository.getAppById(appId))
        }
    }

    fun clickLogo() {
        _events.trySend(AppDetailsEvents.LogoClicked)
    }
}