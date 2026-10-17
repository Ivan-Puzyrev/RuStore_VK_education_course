package com.ivanpuzyrev.rustorevkeducationcourse.presentation.appListScreen

import androidx.lifecycle.ViewModel
import com.ivanpuzyrev.rustorevkeducationcourse.data.AppRepository
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlin.time.Duration.Companion.seconds

class AppListViewModel : ViewModel() {

    private val _state = MutableStateFlow<AppListState>(AppListState.Loading)
    val state = _state.asStateFlow()

    private val _events = Channel<AppListEvent>()
    val events = _events.receiveAsFlow()

    suspend fun loadApps() {
        delay(1.seconds)
        _state.update {
            AppListState.Content(AppRepository.getAppList())
        }
    }

    fun clickLogo() {
        _events.trySend(AppListEvent.LogoClicked)
    }

}