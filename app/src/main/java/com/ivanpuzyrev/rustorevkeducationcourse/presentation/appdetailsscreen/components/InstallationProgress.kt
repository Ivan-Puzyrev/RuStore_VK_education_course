package com.ivanpuzyrev.rustorevkeducationcourse.presentation.appdetailsscreen.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularWavyProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun InstallationProgress(modifier: Modifier = Modifier, progress: Int) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Black.copy(alpha = 0.3f)),
        contentAlignment = Alignment.Center
    ) {
        val animatedProgress =
            animateFloatAsState(
                targetValue = progress / 100f,
                animationSpec = tween(1500)
            )
        CircularWavyProgressIndicator(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            progress = { animatedProgress.value }
        )
        Text(
            text = "${(animatedProgress.value * 100).toInt()}%",
            color = MaterialTheme.colorScheme.onPrimary,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview(showBackground = true)
@Composable
fun InstallationProgressPreview() {
    InstallationProgress(modifier = Modifier.size(150.dp), progress = 15)
}