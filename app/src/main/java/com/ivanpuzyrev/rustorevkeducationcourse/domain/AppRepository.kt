package com.ivanpuzyrev.rustorevkeducationcourse.domain

interface AppRepository {

    suspend fun getAppList(): List<App>
    suspend fun getShowcaseApps(appId: Int): List<App>
    suspend fun getAppById(appId: Int): App

}