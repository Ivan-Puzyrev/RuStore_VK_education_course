package com.ivanpuzyrev.rustorevkeducationcourse.presentation.composables

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
import com.ivanpuzyrev.rustorevkeducationcourse.data.AppRepository
import com.ivanpuzyrev.rustorevkeducationcourse.domain.App
import com.ivanpuzyrev.rustorevkeducationcourse.presentation.system_design.AppListImage
import com.ivanpuzyrev.rustorevkeducationcourse.presentation.utils.toUiString

@Composable
fun AppCard(modifier: Modifier = Modifier, app: App, onCardClick: (Int) -> Unit) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(80.dp)
            .clickable(onClick = { onCardClick(app.id) }),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AppListImage(
            modifier = Modifier.size(80.dp).clip(RoundedCornerShape(16.dp)),
            model = app.iconUrl,
            contentDescription = app.title
        )
        Spacer(Modifier.width(16.dp))
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                text = app.category.toUiString(),
                style = MaterialTheme.typography.labelMedium
            )
            Text(
                text = app.title,
                style = MaterialTheme.typography.headlineMedium,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = app.description,
                style = MaterialTheme.typography.bodyMedium,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun AppCardPreview() {
    AppCard(app = AppRepository.getAppList()[0]) {}
}