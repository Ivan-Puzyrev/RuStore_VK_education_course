package com.ivanpuzyrev.rustorevkeducationcourse.presentation.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.ivanpuzyrev.rustorevkeducationcourse.R
import com.ivanpuzyrev.rustorevkeducationcourse.domain.DataError

@Composable
fun DataError.Network.toUIText(): String = when (this) {
    DataError.Network.REQUEST_TIMEOUT -> stringResource(R.string.request_timeout)
    DataError.Network.UNAUTHORIZED -> stringResource(R.string.unauthorized)
    DataError.Network.TOO_MANY_REQUESTS -> stringResource(R.string.too_many_requests)
    DataError.Network.NO_INTERNET -> stringResource(R.string.no_internet)
    DataError.Network.SERVER_ERROR -> stringResource(R.string.server_error)
    DataError.Network.UNKNOWN -> stringResource(R.string.something_went_wrong)
    DataError.Network.NOT_FOUND -> stringResource(R.string.not_found)
}