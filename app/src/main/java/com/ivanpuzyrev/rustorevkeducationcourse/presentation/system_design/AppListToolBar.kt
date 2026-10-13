package com.ivanpuzyrev.rustorevkeducationcourse.presentation.system_design

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.ivanpuzyrev.rustorevkeducationcourse.domain.App

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppListToolBar(
    modifier: Modifier = Modifier,
    currentApp: App? = null,
    action: (@Composable () -> Unit)? = null,
    onBackClick: () -> Unit
) {
    TopAppBar(
        modifier = modifier,
        colors = TopAppBarDefaults.topAppBarColors().copy(containerColor = MaterialTheme.colorScheme.primary),
        title = {
            currentApp?.let {
                AppListImage(
                    modifier = Modifier
                        .size(36.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .clickable(onClick = onBackClick),
                    model = it.iconUrl,
                    contentDescription = it.title
                )
            }

        },
        navigationIcon = {
                IconButton(onClick = onBackClick) {
                    Icon(
                        modifier = Modifier.size(32.dp),
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back",
                        tint = MaterialTheme.colorScheme.onPrimary
                    )
                }
        },
        actions = {
            Box(Modifier.padding(end = 16.dp)) {
                action?.invoke()
            }
        }
    )
}