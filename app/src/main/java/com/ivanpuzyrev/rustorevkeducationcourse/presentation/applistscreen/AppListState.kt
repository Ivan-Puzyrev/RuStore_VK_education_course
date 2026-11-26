package com.ivanpuzyrev.rustorevkeducationcourse.presentation.applistscreen

import com.ivanpuzyrev.rustorevkeducationcourse.domain.AppInfo
import com.ivanpuzyrev.rustorevkeducationcourse.domain.DataError

sealed interface AppListState {
    data object Initial: AppListState
    data object Loading: AppListState
    data class Error(val error: DataError): AppListState
    data class Content(val appDetails: List<AppInfo>): AppListState
}