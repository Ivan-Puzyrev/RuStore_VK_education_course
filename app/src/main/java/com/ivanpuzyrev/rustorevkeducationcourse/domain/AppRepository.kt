package com.ivanpuzyrev.rustorevkeducationcourse.domain

import kotlinx.coroutines.flow.Flow

interface AppRepository {

    suspend fun getAppList(): Result<List<AppInfo>, DataError.Network>
    suspend fun getShowcaseApps(appId: String): Result<List<AppInfo>, DataError.Network>
    suspend fun getAppById(appId: String): Result<AppDetails, DataError.Network>
    suspend fun installApp(): Flow<Int>

}