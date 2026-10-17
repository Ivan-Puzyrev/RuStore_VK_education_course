package com.ivanpuzyrev.rustorevkeducationcourse.presentation.appdetailsscreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ivanpuzyrev.rustorevkeducationcourse.R
import com.ivanpuzyrev.rustorevkeducationcourse.data.AppRepository

@Composable
fun Developer(modifier: Modifier = Modifier, developer: String, onDeveloperTap: (String) -> Unit) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onDeveloperTap(developer) },
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Text(text = developer, style = MaterialTheme.typography.bodyMedium)
            Text(
                text = stringResource(R.string.developer),
                style = MaterialTheme.typography.bodyMedium
            )
        }
        Icon(imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = null)
    }
}

@Preview(showBackground = true)
@Composable
private fun DeveloperPreview() {
    Developer(
        developer = AppRepository.getAppList()[0].developer,
        onDeveloperTap = {}
    )
}