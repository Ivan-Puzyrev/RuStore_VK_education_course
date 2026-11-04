package com.ivanpuzyrev.rustorevkeducationcourse.presentation.appdetailsscreen

import com.ivanpuzyrev.rustorevkeducationcourse.domain.AppDetails
import com.ivanpuzyrev.rustorevkeducationcourse.domain.AppInfo
import com.ivanpuzyrev.rustorevkeducationcourse.domain.DataError

sealed interface AppDetailsState {
    data object Initial: AppDetailsState
    data object Loading: AppDetailsState
    data class NetworkError (val error: DataError.Network): AppDetailsState
    data class Content(val appDetails: AppDetails, val showCaseAppDetails: List<AppInfo>): AppDetailsState
}