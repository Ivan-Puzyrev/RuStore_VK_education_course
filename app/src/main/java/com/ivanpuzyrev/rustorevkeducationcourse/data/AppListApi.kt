package com.ivanpuzyrev.rustorevkeducationcourse.data

import retrofit2.http.GET
import retrofit2.http.Path

interface AppListApi {

    @GET("/catalog")
    suspend fun loadAppList(): List<AppInfoDTO>

    @GET("/catalog/{id}")
    suspend fun loadAppDetailsById(@Path("id") id: String): AppDetailsDTO

}