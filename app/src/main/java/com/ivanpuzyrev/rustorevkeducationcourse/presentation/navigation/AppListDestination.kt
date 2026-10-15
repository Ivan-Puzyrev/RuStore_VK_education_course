package com.ivanpuzyrev.rustorevkeducationcourse.presentation.navigation

import kotlinx.serialization.Serializable

sealed interface AppListDestination {

    @Serializable
    data object AppList: AppListDestination

    @Serializable
    data class AppScreen(val appId: Int): AppListDestination
}