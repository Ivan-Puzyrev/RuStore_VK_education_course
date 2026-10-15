package com.ivanpuzyrev.rustorevkeducationcourse.presentation.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ivanpuzyrev.rustorevkeducationcourse.R
import com.ivanpuzyrev.rustorevkeducationcourse.data.AppRepository
import com.ivanpuzyrev.rustorevkeducationcourse.domain.App

@Composable
fun Showcase(modifier: Modifier = Modifier, appList: List<App>, onAppTap: (Int) -> Unit) {
    val pagerState = rememberPagerState { appList.size / NUMBER_OF_APPS_ON_PAGE }
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = stringResource(R.string.showcase),
            style = MaterialTheme.typography.headlineMedium
        )
        HorizontalPager(pagerState) {
            val apps = appList.slice(it * NUMBER_OF_APPS_ON_PAGE..it * NUMBER_OF_APPS_ON_PAGE + 2)
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                apps.forEach { app ->
                    AppCard(app) {
                        onAppTap(app.id)
                    }
                }
            }
        }
    }
}

private const val NUMBER_OF_APPS_ON_PAGE = 3

@Preview(showBackground = true)
@Composable
private fun ShowcasePreview() {
    Showcase(
        appList = AppRepository.getAppList().take(9),
        onAppTap = {}
    )
}