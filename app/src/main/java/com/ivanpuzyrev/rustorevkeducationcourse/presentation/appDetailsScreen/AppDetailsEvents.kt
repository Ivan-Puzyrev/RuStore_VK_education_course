package com.ivanpuzyrev.rustorevkeducationcourse.presentation.appDetailsScreen

sealed interface AppDetailsEvents {
    data object Error: AppDetailsEvents
    data object LogoClicked: AppDetailsEvents
}