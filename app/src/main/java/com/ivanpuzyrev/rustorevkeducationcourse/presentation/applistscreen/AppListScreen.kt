package com.ivanpuzyrev.rustorevkeducationcourse.presentation.applistscreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ivanpuzyrev.rustorevkeducationcourse.R
import com.ivanpuzyrev.rustorevkeducationcourse.presentation.systemdesign.AppListToolBar
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest

@Composable
fun AppListScreen(
    modifier: Modifier = Modifier,
    onCardTap: (Int) -> Unit,
    onBackTap: () -> Unit
) {

    val viewModel = viewModel<AppListViewModel>()
    val state by viewModel.state.collectAsStateWithLifecycle()
    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(Unit) {
        viewModel.loadApps()
    }

    ObserveEvents(viewModel.events, snackbarHostState)

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            AppListToolBar(
                onBackTap = onBackTap
            )
        },
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) { innerPadding ->

        when (val state = state) {
            is AppListState.Content -> {
                LazyColumn(
                    modifier = modifier
                        .fillMaxSize()
                        .padding(innerPadding),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    contentPadding = PaddingValues(16.dp)
                ) {
                    items(items = state.apps, key = { it.iconUrl }) {
                        AppCard(
                            app = it,
                            onCardTap = onCardTap,
                            onLogoTap = {
                                viewModel.clickLogo()
                            })
                    }
                }
            }

            AppListState.Loading -> {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator()
                }
            }
        }


    }
}

@Composable
private fun ObserveEvents(
    events: Flow<AppListEvent>,
    snackbarHostState: SnackbarHostState,
) {
    val error = stringResource(R.string.error)
    val logoClicked = stringResource(R.string.logo_clicked)

    LaunchedEffect(Unit) {
        events.collectLatest { event ->
            when (event) {
                AppListEvent.Error -> {
                    snackbarHostState.showSnackbar(error)
                }

                AppListEvent.LogoClicked -> {
                    snackbarHostState.showSnackbar(logoClicked)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun AppListScreenPreview() {
    AppListScreen(onCardTap = {}, onBackTap = {})
}