package com.ivanpuzyrev.rustorevkeducationcourse.presentation.applistscreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ivanpuzyrev.rustorevkeducationcourse.domain.AppInfo
import com.ivanpuzyrev.rustorevkeducationcourse.presentation.systemdesign.AppListImage

@Composable
fun AppCard(modifier: Modifier = Modifier, appInfo: AppInfo, onCardTap: (String) -> Unit, onLogoTap: () -> Unit) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(80.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AppListImage(
            modifier = Modifier
                .size(80.dp)
                .clip(RoundedCornerShape(16.dp))
                .clickable { onLogoTap() },
            model = appInfo.iconUrl,
            contentDescription = appInfo.title
        )
        Spacer(Modifier.width(16.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { onCardTap(appInfo.id) },
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                text = appInfo.category,
                style = MaterialTheme.typography.labelMedium
            )
            Text(
                text = appInfo.title,
                style = MaterialTheme.typography.headlineMedium,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = appInfo.description,
                style = MaterialTheme.typography.bodyMedium,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun AppCardPreview() {
    val appInfo = AppInfo(
        id = "1",
        iconUrl = "https://static.rustore.ru/imgproxy/-fb8TfFrlYjwu7wYCEPuKsm4wWkTLBTx_0_a9GpeKfc/preset:web_app_icon_160/plain/https://static.rustore.ru/apk/2027823295/content/ICON/97486018-5785-424d-9cab-4fe496d27c76.png@webp",
        title = "VK Видео: кино, сериалы, ТВ, мультфильмы и клипы",
        category = "Развлечение",
        description = """Смотри кино, мультики, сериалы, ТВ онлайн, спортивные трансляции, короткие видео и фильмы бесплатно на всех устройствах: от смартфона до телевизора. Премьеры и блокбастеры из кинотеатров и онлайн-платформ на твоем девайсе!

Откройте интертеймент без границ с VK Видео: онлайн-просмотр ТВ, новинки кино и сериалов, познавательные и развлекательные видео, мультики для детей (без интернета), эксклюзивный контент, спортивные трансляции и смешные клипы ждут тебя. Ты можешь скачать видео для офлайн просмотра в один клик."""
    )
    AppCard(appInfo = appInfo, onCardTap = {}) {}
}