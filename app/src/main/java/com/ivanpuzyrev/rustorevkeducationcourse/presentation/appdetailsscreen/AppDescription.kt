package com.ivanpuzyrev.rustorevkeducationcourse.presentation.appdetailsscreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ivanpuzyrev.rustorevkeducationcourse.R
import com.ivanpuzyrev.rustorevkeducationcourse.domain.App
import com.ivanpuzyrev.rustorevkeducationcourse.domain.Category

@Composable
fun AppDescription(modifier: Modifier = Modifier, description: String) {

    var isCollapsed by rememberSaveable { mutableStateOf(true) }

    Column(modifier = modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Text(
            text = stringResource(R.string.app_description),
            style = MaterialTheme.typography.headlineSmall
        )
        Text(
            text = description,
            style = MaterialTheme.typography.bodyMedium,
            maxLines = if (isCollapsed) 1 else Int.MAX_VALUE,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            modifier = Modifier.clickable {
                isCollapsed = !isCollapsed
            },
            text = if (isCollapsed) stringResource(R.string.read_more) else stringResource(R.string.collapse),
            style = MaterialTheme.typography.headlineSmall,
            color = MaterialTheme.colorScheme.primary
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun AppDescriptionPreview() {
    val app = App(
        id = 1,
        iconUrl = "https://static.rustore.ru/imgproxy/-fb8TfFrlYjwu7wYCEPuKsm4wWkTLBTx_0_a9GpeKfc/preset:web_app_icon_160/plain/https://static.rustore.ru/apk/2027823295/content/ICON/97486018-5785-424d-9cab-4fe496d27c76.png@webp",
        title = "VK Видео: кино, сериалы, ТВ, мультфильмы и клипы",
        category = Category.ENTERTAINMENT,
        description = """Смотри кино, мультики, сериалы, ТВ онлайн, спортивные трансляции, короткие видео и фильмы бесплатно на всех устройствах: от смартфона до телевизора. Премьеры и блокбастеры из кинотеатров и онлайн-платформ на твоем девайсе!

Откройте интертеймент без границ с VK Видео: онлайн-просмотр ТВ, новинки кино и сериалов, познавательные и развлекательные видео, мультики для детей (без интернета), эксклюзивный контент, спортивные трансляции и смешные клипы ждут тебя. Ты можешь скачать видео для офлайн просмотра в один клик.""",
        developer = "VK",
        ageLimit = 12,
        size = 96,
        screenshotsUrls = listOf(
            "https://static.rustore.ru/imgproxy/ZCsMXpX_Bp3gIRjnrtPm15UZtsDaEoPlM_o17_9sCvo/preset:web_scr_prt_384/plain/https://static.rustore.ru/2026/4/15/39/apk/2027823295/content/SCREENSHOT/0cff6242-3ca9-4591-b6e7-42fbd31b4b2c.jpg@webp",
            "https://static.rustore.ru/imgproxy/cGHqGrlUXmRaql71aP4Dluu9cC5ftyFai2jy7bHJUQo/preset:web_scr_prt_384/plain/https://static.rustore.ru/2026/4/15/5e/apk/2027823295/content/SCREENSHOT/508b971e-1220-4592-ae1f-a3f31f03dfd7.png@webp",
            "https://static.rustore.ru/imgproxy/X0KjzkehfR5slDEnBiqJiGsE1euR_5HkssZCHwV1Rs4/preset:web_scr_prt_384/plain/https://static.rustore.ru/2026/7/2/f1/apk/2027823295/content/SCREENSHOT/8398b9a4-872c-4880-9b3d-fb885c31551f.png@webp",
            "https://static.rustore.ru/imgproxy/oiqHAEiezmNxr18vBWl_pLHKItgtmgdkItUBX9mt5yM/preset:web_scr_prt_384/plain/https://static.rustore.ru/2026/4/15/7c/apk/2027823295/content/SCREENSHOT/6ce5fc10-745a-4363-b693-6f05803e2b91.png@webp",
            "https://static.rustore.ru/imgproxy/_gPBXyXbUmImpa6kuucTGiEO2FQCPTfPHgm-gzD0sHg/preset:web_scr_prt_384/plain/https://static.rustore.ru/2026/7/13/aa/apk/2027823295/content/SCREENSHOT/e2576fd7-b475-4209-8b67-d0651c05f016.png@webp",
            "https://static.rustore.ru/imgproxy/s07-iEDuleCwnodV98yOZ1Nu-Hr1GgLGl_TVRtQkPzk/preset:web_scr_prt_384/plain/https://static.rustore.ru/2026/4/15/f7/apk/2027823295/content/SCREENSHOT/576f9603-1e46-42c8-9846-1b46e740d5a2.png@webp"
        )
    )
    AppDescription(description = app.description)
}