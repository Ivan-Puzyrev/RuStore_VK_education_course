package com.ivanpuzyrev.rustorevkeducationcourse.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.ivanpuzyrev.rustorevkeducationcourse.R
import com.ivanpuzyrev.rustorevkeducationcourse.data.AppRepository
import com.ivanpuzyrev.rustorevkeducationcourse.presentation.system_design.AppListToolBar
import com.ivanpuzyrev.rustorevkeducationcourse.ui.theme.RuStoreVKEducationCourseTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RuStoreVKEducationCourseTheme {

                val snackbarHostState = remember { SnackbarHostState() }
                val scope = rememberCoroutineScope()

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        AppListToolBar(
                            onBackClick = {
                                if (snackbarHostState.currentSnackbarData?.visuals?.message != getString(
                                        R.string.no_way_back
                                    )
                                ) {
                                    snackbarHostState.currentSnackbarData?.dismiss()
                                    scope.launch {
                                        snackbarHostState.showSnackbar(getString(R.string.no_way_back))
                                    }
                                }
                            }
                        )
                    },
                    snackbarHost = { SnackbarHost(snackbarHostState) }
                ) { innerPadding ->
                    AppListScreen(
                        modifier = Modifier.padding(innerPadding),
                        appList = AppRepository.getShuffledAppList(),
                        onCardClick = {
                            if (snackbarHostState.currentSnackbarData?.visuals?.message != getString(R.string.i_am_it, it)) {
                                snackbarHostState.currentSnackbarData?.dismiss()
                                scope.launch {
                                    snackbarHostState.showSnackbar(getString(R.string.i_am_it, it))
                                }
                            }
                        }
                    )
                }
            }
        }
    }
}