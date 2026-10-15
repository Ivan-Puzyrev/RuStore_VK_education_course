package com.ivanpuzyrev.rustorevkeducationcourse.presentation.composables

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
import com.ivanpuzyrev.rustorevkeducationcourse.data.AppRepository

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
            text = stringResource(R.string.read_more),
            style = MaterialTheme.typography.headlineSmall,
            color = MaterialTheme.colorScheme.primary
        )

    }
}

@Preview(showBackground = true)
@Composable
private fun AppDescriptionPreview() {
    AppDescription(description = AppRepository.getAppList()[0].description)
}