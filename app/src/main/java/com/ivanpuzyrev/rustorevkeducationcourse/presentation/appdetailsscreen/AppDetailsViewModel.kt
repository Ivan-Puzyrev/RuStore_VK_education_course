package com.ivanpuzyrev.rustorevkeducationcourse.presentation.appdetailsscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ivanpuzyrev.rustorevkeducationcourse.data.AppListApi
import com.ivanpuzyrev.rustorevkeducationcourse.data.AppRepositoryImpl
import com.ivanpuzyrev.rustorevkeducationcourse.data.Mapper
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.seconds

class AppDetailsViewModel(appId: Int) : ViewModel() {

    private val appRepository = AppRepositoryImpl(
        appListApi = AppListApi(),
        mapper = Mapper()
    )

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
}