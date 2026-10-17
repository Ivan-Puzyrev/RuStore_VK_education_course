package com.ivanpuzyrev.rustorevkeducationcourse.presentation.applistscreen

import com.ivanpuzyrev.rustorevkeducationcourse.domain.App

sealed interface AppListState {
    data object Loading: AppListState
    data class Content(val apps: List<App>): AppListState
}