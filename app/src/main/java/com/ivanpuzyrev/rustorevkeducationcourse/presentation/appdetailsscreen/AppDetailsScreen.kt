package com.ivanpuzyrev.rustorevkeducationcourse.presentation.appdetailsscreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ivanpuzyrev.rustorevkeducationcourse.R
import com.ivanpuzyrev.rustorevkeducationcourse.presentation.systemdesign.AppListImage
import com.ivanpuzyrev.rustorevkeducationcourse.presentation.systemdesign.AppListToolBar
import com.ivanpuzyrev.rustorevkeducationcourse.presentation.systemdesign.ErrorMessage
import com.ivanpuzyrev.rustorevkeducationcourse.presentation.utils.toUIText
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest

@Composable
fun AppDetailsScreen(
    modifier: Modifier = Modifier,
    appId: String,
    onBackTap: () -> Unit,
    onAppTap: (String) -> Unit
) {

    val viewModel = hiltViewModel<AppDetailsViewModel, AppDetailsViewModel.Factory>(
        creationCallback = { factory -> factory.create(appId) }
    )

    val state by viewModel.state.collectAsStateWithLifecycle()
    val snackbarHostState = remember { SnackbarHostState() }

    ObserveEvents(viewModel.events, snackbarHostState)

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            AppListToolBar(
                action = {
                    IconButton(
                                onClick = { }
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
        },
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) { innerPadding ->

        when (val state = state) {
            is AppDetailsState.Content -> {
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
                                .clip(RoundedCornerShape(16.dp))
                                .clickable { viewModel.clickLogo() },
                            model = state.appDetails.iconUrl,
                            contentDescription = state.appDetails.title
                        )
                        Column(
                            modifier = Modifier.fillMaxWidth(),
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Text(
                                text = state.appDetails.category,
                                style = MaterialTheme.typography.labelMedium
                            )
                            Text(
                                text = state.appDetails.title,
                                style = MaterialTheme.typography.headlineLarge
                            )
                            Text(
                                text = state.appDetails.developer,
                                style = MaterialTheme.typography.bodySmall
                            )
                            Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                                AppSpec(
                                    spec = "${state.appDetails.ageRating}+",
                                    specTitle = stringResource(R.string.age)
                                )
                                AppSpec(
                                    spec = "${state.appDetails.size} ${stringResource(R.string.mb)}",
                                    specTitle = stringResource(R.string.size)
                                )
                            }
                        }
                    }

                    Button(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(8.dp),
                        onClick = { }
                    ) {
                        Text(
                            modifier = Modifier.padding(4.dp),
                            text = stringResource(R.string.install)
                        )
                    }

                    Screenshots(
                        screenshotsUrls = state.appDetails.screenshotsUrls
                    )

                    AppDescription(
                        description = state.appDetails.description
                    )

                    HorizontalDivider(modifier = Modifier.fillMaxWidth())

                    Developer(developer = state.appDetails.developer)

                    HorizontalDivider(modifier = Modifier.fillMaxWidth())

                    Showcase(
                        appInfoList = state.showCaseAppDetails,
                        onAppTap = onAppTap,
                        onLogoTap = {
                            viewModel.clickLogo()
                        }
                    )
                }
            }

            AppDetailsState.Loading -> {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator()
                }
            }

            is AppDetailsState.NetworkError -> {
                    ErrorMessage(message = state.error.toUIText()) {
                        viewModel.loadApp(appId)
                    }
            }
            AppDetailsState.Initial -> {}
        }

    }
}

@Composable
private fun ObserveEvents(
    events: Flow<AppDetailsEvents>,
    snackbarHostState: SnackbarHostState,
) {
    val error = stringResource(R.string.error)
    val logoClicked = stringResource(R.string.logo_clicked)

    LaunchedEffect(Unit) {
        events.collectLatest { event ->
            when (event) {
                AppDetailsEvents.Error -> {
                    snackbarHostState.showSnackbar(error)
                }

                AppDetailsEvents.LogoClicked -> {
                    snackbarHostState.showSnackbar(logoClicked)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun AppDetailsScreenPreview() {
    AppDetailsScreen(
        appId = "fa2e31b8-1234-4cf7-9914-108a170a1b01",
        onBackTap = {},
        onAppTap = {}
    )
}