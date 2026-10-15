package com.ivanpuzyrev.rustorevkeducationcourse.presentation

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ivanpuzyrev.rustorevkeducationcourse.R
import com.ivanpuzyrev.rustorevkeducationcourse.data.AppRepository
import com.ivanpuzyrev.rustorevkeducationcourse.domain.App
import com.ivanpuzyrev.rustorevkeducationcourse.presentation.composables.AppDescription
import com.ivanpuzyrev.rustorevkeducationcourse.presentation.composables.AppSpec
import com.ivanpuzyrev.rustorevkeducationcourse.presentation.composables.Developer
import com.ivanpuzyrev.rustorevkeducationcourse.presentation.composables.Screenshots
import com.ivanpuzyrev.rustorevkeducationcourse.presentation.composables.Showcase
import com.ivanpuzyrev.rustorevkeducationcourse.presentation.system_design.AppListImage
import com.ivanpuzyrev.rustorevkeducationcourse.presentation.system_design.AppListToolBar
import com.ivanpuzyrev.rustorevkeducationcourse.presentation.utils.toUiString

@Composable
fun AppScreen(modifier: Modifier = Modifier, app: App, onBackTap: () -> Unit, onAppTap: (Int) -> Unit) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            AppListToolBar(
                action = {
                    IconButton(
                        onClick = {
                            Log.d("Tap", "Share Button Tapped")
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Share,
                            contentDescription = stringResource(R.string.share_button),
                            tint = MaterialTheme.colorScheme.onPrimary
                        )
                    }
                },
                onBackTap = onBackTap
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(12.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                AppListImage(
                    modifier = Modifier
                        .size(125.dp)
                        .clip(RoundedCornerShape(16.dp)),
                    model = app.iconUrl,
                    contentDescription = app.title
                )
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(text = app.category.toUiString(), style = MaterialTheme.typography.labelMedium)
                    Text(text = app.title, style = MaterialTheme.typography.headlineLarge)
                    Text(text = app.developer, style = MaterialTheme.typography.bodySmall)
                    Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                        AppSpec(spec = "${app.ageLimit}+", specTitle = stringResource(R.string.age))
                        AppSpec(spec = "${app.size} MB", specTitle = stringResource(R.string.size))
                    }
                }
            }

            Button(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(8.dp),
                onClick = {
                    Log.d("Tap", "Install Button Tapped")
                }
            ) {
                Text(modifier = Modifier.padding(4.dp), text = stringResource(R.string.install))
            }

            Screenshots(
                screenshotsUrls = app.screenshotsUrls
            )

            AppDescription(
                description = app.description
            )

            HorizontalDivider(modifier = Modifier.fillMaxWidth())

            Developer(developer = app.developer) {
                Log.d("Tap", "Developer: $it")
            }

            HorizontalDivider(modifier = Modifier.fillMaxWidth())

            Showcase(
                appList = AppRepository.getAppList().take(9),
                onAppTap = onAppTap
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun AppScreenPreview() {
    AppScreen(
        app = AppRepository.getAppList()[1],
        onBackTap = {},
        onAppTap = {}
    )
}