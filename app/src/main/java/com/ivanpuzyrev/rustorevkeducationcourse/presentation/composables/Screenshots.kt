package com.ivanpuzyrev.rustorevkeducationcourse.presentation.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ivanpuzyrev.rustorevkeducationcourse.R
import com.ivanpuzyrev.rustorevkeducationcourse.data.AppRepository
import com.ivanpuzyrev.rustorevkeducationcourse.presentation.system_design.AppListImage

@Composable
fun Screenshots(modifier: Modifier = Modifier, screenshotsUrls: List<String>) {

    val pagerState = rememberPagerState { screenshotsUrls.size / NUMBER_OF_SCREENSHOTS_ON_PAGE }
    val screenshotsPages by remember { mutableStateOf(screenshotsUrls.chunked(NUMBER_OF_SCREENSHOTS_ON_PAGE)) }

    Column(modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Text(
            text = stringResource(R.string.screenshots),
            style = MaterialTheme.typography.headlineMedium
        )
        HorizontalPager(pagerState) { pageNumber ->
            val (firstScreenshot, secondScreenshot) = screenshotsPages[pageNumber]
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                AppListImage(
                    modifier = Modifier
                        .height(300.dp)
                        .clip(RoundedCornerShape(8.dp)),
                    firstScreenshot,
                    null
                )
                AppListImage(
                    modifier = Modifier
                        .height(300.dp)
                        .clip(RoundedCornerShape(8.dp)),
                    secondScreenshot,
                    null
                )
            }
        }
    }
}

private const val NUMBER_OF_SCREENSHOTS_ON_PAGE = 2

@Preview(showBackground = true)
@Composable
private fun ScreenshotsPreview() {
    Screenshots(screenshotsUrls = AppRepository.getAppList()[0].screenshotsUrls)
}