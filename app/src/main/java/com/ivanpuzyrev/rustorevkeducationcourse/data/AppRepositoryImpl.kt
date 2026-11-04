package com.ivanpuzyrev.rustorevkeducationcourse.data

import com.ivanpuzyrev.rustorevkeducationcourse.data.utils.safeCall
import com.ivanpuzyrev.rustorevkeducationcourse.domain.AppRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppRepositoryImpl @Inject constructor (
    private val appListApi: AppListApi,
    private val mapper: Mapper
): AppRepository {

    override suspend fun getAppList() = safeCall { appListApi.loadAppList().shuffled().map { mapper.appInfoDTOtoAppInfo(it) } }
    override suspend fun getShowcaseApps(appId: String) = safeCall { appListApi.loadAppList().filter { it.id != appId }.shuffled().take(12).map { mapper.appInfoDTOtoAppInfo(it) } }
    override suspend fun getAppById(appId: String) = safeCall { mapper.appDetailsDTOtoAppDetails(appListApi.loadAppDetailsById(appId)) }

}