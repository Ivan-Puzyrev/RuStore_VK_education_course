package com.ivanpuzyrev.rustorevkeducationcourse.presentation.appListScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ivanpuzyrev.rustorevkeducationcourse.data.AppRepository
import com.ivanpuzyrev.rustorevkeducationcourse.domain.App
import com.ivanpuzyrev.rustorevkeducationcourse.presentation.system_design.AppListToolBar

@Composable
fun AppListScreen(
    modifier: Modifier = Modifier,
    appList: List<App>,
    currentApp: App? = null,
    onCardTap: (Int) -> Unit,
    onLogoTap: () -> Unit,
    onBackTap: () -> Unit
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            AppListToolBar(
                currentApp = currentApp,
                onBackTap = onBackTap
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(16.dp)
        ) {
            items(items = appList, key = { it.iconUrl }) {
                AppCard(app = it, onCardTap = onCardTap, onLogoTap = onLogoTap)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun AppListScreenPreview() {
    AppListScreen(appList = AppRepository.getAppList(), currentApp = null, onCardTap = {}, onBackTap = {}, onLogoTap = {})
}