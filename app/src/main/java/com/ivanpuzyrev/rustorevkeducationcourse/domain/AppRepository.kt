package com.ivanpuzyrev.rustorevkeducationcourse.domain

import kotlinx.coroutines.flow.Flow

interface AppRepository {
    suspend fun getApps(): Result<List<AppInfo>, DataError>
    suspend fun getShowcaseApps(appId: String): Result<List<AppInfo>, DataError>
    suspend fun getAppDetailsById(appId: String): Result<Flow<AppDetails>, DataError>
    suspend fun installApp(): Flow<Int>
    suspend fun toggleWishlistStatus(id: String)
}