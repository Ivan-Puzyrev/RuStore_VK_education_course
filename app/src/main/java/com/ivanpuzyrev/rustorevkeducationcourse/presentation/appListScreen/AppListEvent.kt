package com.ivanpuzyrev.rustorevkeducationcourse.presentation.appListScreen

sealed interface AppListEvent {
    data object Error: AppListEvent
    data object LogoClicked: AppListEvent
}