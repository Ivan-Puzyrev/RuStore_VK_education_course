package com.ivanpuzyrev.rustorevkeducationcourse.presentation.appdetailsscreen

import com.ivanpuzyrev.rustorevkeducationcourse.domain.App

sealed interface AppDetailsState {
    data object Initial: AppDetailsState
    data object Loading: AppDetailsState
    data object Error: AppDetailsState
    data class Content(val app: App, val showCaseApps: List<App>): AppDetailsState
}