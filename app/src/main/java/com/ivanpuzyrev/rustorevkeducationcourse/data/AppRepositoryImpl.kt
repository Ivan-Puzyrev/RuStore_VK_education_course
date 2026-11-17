package com.ivanpuzyrev.rustorevkeducationcourse.data

import com.ivanpuzyrev.rustorevkeducationcourse.data.utils.safeCall
import com.ivanpuzyrev.rustorevkeducationcourse.domain.AppRepository
import com.ivanpuzyrev.rustorevkeducationcourse.presentation.appdetailsscreen.AppDetailsState
import com.ivanpuzyrev.rustorevkeducationcourse.presentation.appdetailsscreen.InstallState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.update
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.seconds

@Singleton
class AppRepositoryImpl @Inject constructor (
    private val appListApi: AppListApi,
    private val mapper: Mapper
): AppRepository {

    override suspend fun getAppList() = safeCall { mapper.appInfoDTOListToAppInfoList(appListApi.loadAppList()) }
    override suspend fun getShowcaseApps(appId: String) = safeCall { mapper.appInfoDTOListToAppInfoList(appListApi.loadAppList().filter { it.id != appId }.shuffled().take(12)) }
    override suspend fun getAppById(appId: String) = safeCall { mapper.appDetailsDTOtoAppDetails(appListApi.loadAppDetailsById(appId)) }
    override suspend fun installApp(): Flow<Int> = flow {
        emit(0)
        delay(200.milliseconds)
        emit((30..60).random())
        delay(2.seconds)
        emit((75..90).random())
        delay(2.seconds)
        emit(99)
        delay(2.seconds)
        emit(100)
    }

}