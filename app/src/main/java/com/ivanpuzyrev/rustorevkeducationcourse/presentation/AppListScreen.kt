package com.ivanpuzyrev.rustorevkeducationcourse.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.SubcomposeAsyncImage
import com.ivanpuzyrev.rustorevkeducationcourse.domain.App

@Composable
fun AppListScreen(modifier: Modifier, appList: List<App>, onCardClick: (String) -> Unit) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(items = appList, key = { it.icon }) {
            AppCard(app = it, onCardClick = onCardClick)
        }
    }
}

@Composable
fun AppCard(app: App, onCardClick: (String) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .clickable(onClick = { onCardClick(app.title) })
    ) {
        SubcomposeAsyncImage(
            modifier = Modifier.clip(RoundedCornerShape(16.dp)),
            model = app.icon,
            contentDescription = app.title,
            loading = {
                Box(modifier = Modifier.size(80.dp), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator(modifier = Modifier.size(32.dp))
                }
            },
            error = {
                Box(modifier = Modifier.size(80.dp), contentAlignment = Alignment.Center) {
                    Icon(
                        modifier = Modifier.size(32.dp),
                        imageVector = Icons.Default.Close,
                        contentDescription = app.title
                    )
                }
            }
        )
        Spacer(Modifier.width(16.dp))
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                fontSize = 14.sp,
                text = app.category.text,
                color = Color.Gray
            )
            Text(
                text = app.title,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(Modifier.height(4.dp))
            Text(
                text = app.description,
                fontSize = 14.sp,
                lineHeight = 16.sp,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}