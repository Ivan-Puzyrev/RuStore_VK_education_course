package com.ivanpuzyrev.rustorevkeducationcourse.domain

interface AppRepository {

    suspend fun getAppList(): List<App>
    suspend fun getShowcaseApps(): List<App>
    suspend fun getAppById(appId: Int): App

}