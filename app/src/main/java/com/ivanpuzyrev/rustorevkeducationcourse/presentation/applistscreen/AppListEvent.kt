package com.ivanpuzyrev.rustorevkeducationcourse.presentation.applistscreen

sealed interface AppListEvent {
    data object Error: AppListEvent
    data object LogoClicked: AppListEvent
}