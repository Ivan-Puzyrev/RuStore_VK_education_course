package com.ivanpuzyrev.rustorevkeducationcourse.presentation.appdetailsscreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun AppSpec(modifier: Modifier = Modifier, spec: String, specTitle: String) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = spec, style = MaterialTheme.typography.bodyLarge)
        Text(text = specTitle, style = MaterialTheme.typography.bodyLarge)
    }
}

@Preview(showBackground = true)
@Composable
private fun AppSpecPreview() {
    AppSpec(
        spec = "5 MB",
        specTitle = "Размер"
    )
}