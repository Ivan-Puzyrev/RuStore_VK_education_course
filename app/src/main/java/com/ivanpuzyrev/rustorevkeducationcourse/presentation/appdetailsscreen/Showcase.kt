package com.ivanpuzyrev.rustorevkeducationcourse.presentation.appdetailsscreen

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ivanpuzyrev.rustorevkeducationcourse.R
import com.ivanpuzyrev.rustorevkeducationcourse.domain.AppInfo
import com.ivanpuzyrev.rustorevkeducationcourse.presentation.applistscreen.AppCard

@Composable
fun Showcase(
    modifier: Modifier = Modifier,
    appInfoList: List<AppInfo>,
    onAppTap: (String) -> Unit,
    onLogoTap: () -> Unit
) {

    val numberOfAppsOnPage = if (LocalConfiguration.current.orientation == Configuration.ORIENTATION_LANDSCAPE) 6 else 3
    val pagerState = rememberPagerState { appInfoList.size / numberOfAppsOnPage }
    val appsPages by remember { mutableStateOf(appInfoList.chunked(numberOfAppsOnPage)) }

    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = stringResource(R.string.showcase),
            style = MaterialTheme.typography.headlineMedium
        )
        HorizontalPager(pagerState) { pageNumber ->
            val appsOnPage = appsPages[pageNumber].chunked(3)

            Row(modifier.fillMaxWidth()) {
                appsOnPage.forEach { column ->
                    Column(
                        modifier = Modifier.weight(1f).padding(8.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        column.forEach { app ->
                            AppCard(
                                appInfo = app,
                                onCardTap = { onAppTap(app.id) },
                                onLogoTap = onLogoTap
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ShowcasePreview() {
    val appDetails = AppInfo(
        id = "1",
        iconUrl = "https://static.rustore.ru/imgproxy/-fb8TfFrlYjwu7wYCEPuKsm4wWkTLBTx_0_a9GpeKfc/preset:web_app_icon_160/plain/https://static.rustore.ru/apk/2027823295/content/ICON/97486018-5785-424d-9cab-4fe496d27c76.png@webp",
        title = "VK Видео: кино, сериалы, ТВ, мультфильмы и клипы",
        category = "Развлечение",
        description = """Смотри кино, мультики, сериалы, ТВ онлайн, спортивные трансляции, короткие видео и фильмы бесплатно на всех устройствах: от смартфона до телевизора. Премьеры и блокбастеры из кинотеатров и онлайн-платформ на твоем девайсе!

Откройте интертеймент без границ с VK Видео: онлайн-просмотр ТВ, новинки кино и сериалов, познавательные и развлекательные видео, мультики для детей (без интернета), эксклюзивный контент, спортивные трансляции и смешные клипы ждут тебя. Ты можешь скачать видео для офлайн просмотра в один клик."""
    )

    Showcase(
        appInfoList = buildList {
            repeat(9) { add(appDetails) }
        },
        onAppTap = {},
        onLogoTap = {}
    )
}