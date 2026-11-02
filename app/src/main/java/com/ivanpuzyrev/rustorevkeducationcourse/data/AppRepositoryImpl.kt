package com.ivanpuzyrev.rustorevkeducationcourse.data

import com.ivanpuzyrev.rustorevkeducationcourse.domain.AppRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppRepositoryImpl @Inject constructor (
    private val appListApi: AppListApi,
    private val mapper: Mapper
): AppRepository {

    override suspend fun getAppList() = appListApi.loadAppList().map { mapper.appDTOtoDomainApp(it) }
    override suspend fun getShowcaseApps(appId: Int) = appListApi.loadShowcaseApps(appId).map { mapper.appDTOtoDomainApp(it) }
    override suspend fun getAppById(appId: Int) = mapper.appDTOtoDomainApp(appListApi.loadAppById(appId))


}