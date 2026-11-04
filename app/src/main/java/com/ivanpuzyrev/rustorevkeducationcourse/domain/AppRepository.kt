package com.ivanpuzyrev.rustorevkeducationcourse.domain

interface AppRepository {

    suspend fun getAppList(): Result<List<AppInfo>, DataError.Network>
    suspend fun getShowcaseApps(appId: String): Result<List<AppInfo>, DataError.Network>
    suspend fun getAppById(appId: String): Result<AppDetails, DataError.Network>

}