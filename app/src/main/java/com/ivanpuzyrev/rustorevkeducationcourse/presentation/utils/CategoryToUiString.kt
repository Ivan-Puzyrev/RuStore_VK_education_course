package com.ivanpuzyrev.rustorevkeducationcourse.presentation.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.ivanpuzyrev.rustorevkeducationcourse.R
import com.ivanpuzyrev.rustorevkeducationcourse.domain.Category

@Composable
fun Category.toUiString(): String {
    return when (this) {
        Category.ENTERTAINMENT -> stringResource(R.string.entertainment)
        Category.COMMUNICATION -> stringResource(R.string.communication)
        Category.SERVICES -> stringResource(R.string.services)
        Category.FINANCE -> stringResource(R.string.finance)
        Category.SHOPPING -> stringResource(R.string.shopping)
        Category.GOVERNMENT -> stringResource(R.string.government)
        Category.MAPS -> stringResource(R.string.maps)
    }
}