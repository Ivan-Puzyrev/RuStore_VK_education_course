package com.ivanpuzyrev.rustorevkeducationcourse.data

import com.ivanpuzyrev.rustorevkeducationcourse.domain.AppRepository


class AppRepositoryImpl(
    private val appListApi: AppListApi,
    private val mapper: Mapper
): AppRepository {

    override suspend fun getAppList() = appListApi.loadAppList().map { mapper.appDTOtoDomainApp(it) }
    override suspend fun getShowcaseApps() = appListApi.loadShowcaseApps().map { mapper.appDTOtoDomainApp(it) }
    override suspend fun getAppById(appId: Int) = mapper.appDTOtoDomainApp(appListApi.loadAppById(appId))


}