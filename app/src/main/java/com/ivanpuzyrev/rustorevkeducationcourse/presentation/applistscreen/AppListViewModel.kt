package com.ivanpuzyrev.rustorevkeducationcourse.presentation.applistscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ivanpuzyrev.rustorevkeducationcourse.domain.AppRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.ensureActive
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AppListViewModel @Inject constructor (val appRepository: AppRepository) : ViewModel() {

    private val _state = MutableStateFlow<AppListState>(AppListState.Initial)
    val state = _state.asStateFlow()

    private val _events = Channel<AppListEvent>()
    val events = _events.receiveAsFlow()

    init {
        loadApps()
    }

    fun loadApps() {
        viewModelScope.launch {
            _state.update { AppListState.Loading }
            try {
                val apps = appRepository.getAppList()
                _state.update {
                    AppListState.Content(apps)
                }
            } catch (_: Exception) {
                ensureActive()
                _state.update { AppListState.Error }
            }
        }
    }

    fun clickLogo() {
        _events.trySend(AppListEvent.LogoClicked)
    }

}