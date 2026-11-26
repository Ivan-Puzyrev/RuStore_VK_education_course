package com.ivanpuzyrev.rustorevkeducationcourse.data

import com.ivanpuzyrev.rustorevkeducationcourse.data.api.AppListApi
import com.ivanpuzyrev.rustorevkeducationcourse.data.db.AppDAO
import com.ivanpuzyrev.rustorevkeducationcourse.data.utils.safeCall
import com.ivanpuzyrev.rustorevkeducationcourse.domain.AppDetails
import com.ivanpuzyrev.rustorevkeducationcourse.domain.AppInfo
import com.ivanpuzyrev.rustorevkeducationcourse.domain.AppRepository
import com.ivanpuzyrev.rustorevkeducationcourse.domain.DataError
import com.ivanpuzyrev.rustorevkeducationcourse.domain.Result
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.seconds

@Singleton
class AppRepositoryImpl @Inject constructor(
    private val appListApi: AppListApi,
    private val appDAO: AppDAO,
    private val mapper: Mapper
) : AppRepository {

    override suspend fun toggleWishlistStatus(id: String) {
        appDAO.toggleWishlistStatus(id)
    }

    override suspend fun getApps(): Result<List<AppInfo>, DataError> {
        val appInfosFromDb = try {
            appDAO.getAppInfo()
        } catch (_: Exception) {
            return Result.Failure(DataError.DataBase)
        }
        return if (appInfosFromDb.isNotEmpty()) {
            Result.Success(appInfosFromDb.map { mapper.appInfoEntityToAppInfo(it) })
        } else {
            val appInfosDownloadResult = safeCall { appListApi.loadAppList() }
            when (appInfosDownloadResult) {
                is Result.Failure -> Result.Failure(appInfosDownloadResult.error)
                is Result.Success -> {
                    try {
                        appInfosDownloadResult.data.forEach {
                            appDAO.insertAppInfo(mapper.appInfoDTOtoAppInfoEntity(it))
                        }
                    } catch (_: Exception) {
                        return Result.Failure(DataError.DataBase)
                    }
                    Result.Success(appInfosDownloadResult.data.map { mapper.appInfoDTOtoAppInfo(it) })
                }
            }
        }
    }

    override suspend fun getShowcaseApps(appId: String): Result<List<AppInfo>, DataError> {
        val appInfosFromDb = try {
            appDAO.getAppInfo()
        } catch (_: Exception) {
            return Result.Failure(DataError.DataBase)
        }
        return Result.Success(
            appInfosFromDb.shuffled().filter { it.id != appId }.take(12)
                .map { mapper.appInfoEntityToAppInfo(it) })
    }

    override suspend fun getAppDetailsById(appId: String): Result<Flow<AppDetails>, DataError> {
        val appDetailsFlow = try {
            appDAO.getAppDetailsById(appId)
        } catch (_: Exception) {
            return Result.Failure(DataError.DataBase)
        }
        if (appDetailsFlow.first() == null) {
            val appDetailsDownloadResult = safeCall { appListApi.loadAppDetailsById(appId) }
            when (appDetailsDownloadResult) {
                is Result.Failure -> return Result.Failure(appDetailsDownloadResult.error)
                is Result.Success -> {
                    appDAO.insertAppDetails(
                        mapper.appDetailsDTOtoAppDetailsEntity(
                            appDetailsDownloadResult.data
                        )
                    )
                }
            }
        }
        return Result.Success(
            appDetailsFlow.filterNotNull().map { mapper.appDetailsEntityToAppDetails(it) })
    }

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