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
import com.ivanpuzyrev.rustorevkeducationcourse.presentation.appListScreen.AppListScreen
import com.ivanpuzyrev.rustorevkeducationcourse.presentation.appDetailsScreen.AppDetailsScreen

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

            AppDetailsScreen(
                appId = appId,
                onBackTap = {
                    navController.popBackStack()
                },
                onAppTap = {
                    navController.popBackStack()
                })
        }
    }
}