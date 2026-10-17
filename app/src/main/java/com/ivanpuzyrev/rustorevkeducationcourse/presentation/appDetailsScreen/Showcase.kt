package com.ivanpuzyrev.rustorevkeducationcourse.presentation.appDetailsScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ivanpuzyrev.rustorevkeducationcourse.R
import com.ivanpuzyrev.rustorevkeducationcourse.data.AppRepository
import com.ivanpuzyrev.rustorevkeducationcourse.domain.App
import com.ivanpuzyrev.rustorevkeducationcourse.presentation.appListScreen.AppCard

@Composable
fun Showcase(modifier: Modifier = Modifier, appList: List<App>, onAppTap: (Int) -> Unit) {

    val pagerState = rememberPagerState { appList.size / NUMBER_OF_APPS_ON_PAGE }
    val appsPages by remember { mutableStateOf(appList.chunked(NUMBER_OF_APPS_ON_PAGE)) }

    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = stringResource(R.string.showcase),
            style = MaterialTheme.typography.headlineMedium
        )
        HorizontalPager(pagerState) { pageNumber ->
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                appsPages[pageNumber].forEach { app ->
                    AppCard(
                        app = app,
                        onCardTap = {
                            onAppTap(app.id)
                        },
                        onLogoTap = {

                        })
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