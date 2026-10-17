package com.ivanpuzyrev.rustorevkeducationcourse.presentation.appdetailsscreen

sealed interface AppDetailsEvents {
    data object Error: AppDetailsEvents
    data object LogoClicked: AppDetailsEvents
}