package com.ivanpuzyrev.rustorevkeducationcourse.presentation.appdetailsscreen

import com.ivanpuzyrev.rustorevkeducationcourse.domain.App

sealed interface AppDetailsState {
    data object Loading: AppDetailsState
    data class Content(val app: App): AppDetailsState
}