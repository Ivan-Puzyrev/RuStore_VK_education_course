package com.ivanpuzyrev.rustorevkeducationcourse.presentation.navigation

import androidx.activity.compose.LocalActivity
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.ivanpuzyrev.rustorevkeducationcourse.data.AppRepository
import com.ivanpuzyrev.rustorevkeducationcourse.presentation.AppListScreen
import com.ivanpuzyrev.rustorevkeducationcourse.presentation.AppScreen

@Composable
fun AppNavGraph(modifier: Modifier = Modifier) {

    val navController = rememberNavController()
    val activity = LocalActivity.current

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = AppListDestination.AppList,
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None }
    ) {

        composable<AppListDestination.AppList> {
            AppListScreen(
                appList = AppRepository.getAppList(),
                onCardTap = {
                    navController.navigate(AppListDestination.AppScreen(it))
                },
                onBackTap = {
                    activity?.finish()
                }
            )
        }

        composable<AppListDestination.AppScreen> { backStackEntry ->
            val appId = backStackEntry.toRoute<AppListDestination.AppScreen>().appId
            val app = AppRepository.getAppById(appId)
            AppScreen(
                app = app,
                onBackTap = {
                    navController.popBackStack()
                },
                onAppTap = {
                    navController.popBackStack()
                })
        }

    }
}