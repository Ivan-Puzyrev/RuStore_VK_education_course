package com.ivanpuzyrev.rustorevkeducationcourse.presentation.applistscreen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ivanpuzyrev.rustorevkeducationcourse.domain.AppRepository
import com.ivanpuzyrev.rustorevkeducationcourse.domain.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AppListViewModel @Inject constructor(val appRepository: AppRepository) : ViewModel() {

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
            val appsResult = appRepository.getAppList()
            _state.update {
                when (appsResult) {
                    is Result.Failure -> AppListState.NetWorkError((appsResult.error))
                    is Result.Success -> AppListState.Content(appsResult.data)
                }

            }
        }
    }

    fun clickLogo() {
        _events.trySend(AppListEvent.LogoClicked)
    }
}