package com.ivanpuzyrev.rustorevkeducationcourse.presentation.applistscreen

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

class AppListViewModel : ViewModel() {

    private val appRepository = AppRepository()

    private val _state = MutableStateFlow<AppListState>(AppListState.Initial)
    val state = _state.asStateFlow()

    private val _events = Channel<AppListEvent>()
    val events = _events.receiveAsFlow()

    fun loadApps() {
        viewModelScope.launch {
            _state.update { AppListState.Loading }
            delay(1.seconds)
            try {
                val apps = appRepository.getAppList()
                _state.update {
                    AppListState.Content(apps)
                }
            } catch (_: Exception) {
                _state.update { AppListState.Error }
            }
        }
    }

    fun clickLogo() {
        _events.trySend(AppListEvent.LogoClicked)
    }

}