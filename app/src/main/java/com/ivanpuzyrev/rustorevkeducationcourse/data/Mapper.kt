package com.ivanpuzyrev.rustorevkeducationcourse.data

import androidx.annotation.VisibleForTesting
import com.ivanpuzyrev.rustorevkeducationcourse.data.api.AppDetailsDTO
import com.ivanpuzyrev.rustorevkeducationcourse.data.api.AppInfoDTO
import com.ivanpuzyrev.rustorevkeducationcourse.data.db.AppDetailsEntity
import com.ivanpuzyrev.rustorevkeducationcourse.data.db.AppInfoEntity
import com.ivanpuzyrev.rustorevkeducationcourse.domain.AppDetails
import com.ivanpuzyrev.rustorevkeducationcourse.domain.AppInfo
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Mapper @Inject constructor() {


    fun appDetailsDTOtoAppDetailsEntity(appDetailsDTO: AppDetailsDTO): AppDetailsEntity =
        AppDetailsEntity(
            id = appDetailsDTO.id,
            title = appDetailsDTO.name,
            iconUrl = appDetailsDTO.iconUrl,
            category = appDetailsDTO.category,
            developer = appDetailsDTO.developer,
            ageRating = appDetailsDTO.ageRating,
            size = appDetailsDTO.size,
            screenshotsUrls = appDetailsDTO.screenshotUrlList,
            description = appDetailsDTO.description
        )

    fun appInfoDTOtoAppInfoEntity(appInfoDTO: AppInfoDTO): AppInfoEntity = AppInfoEntity(
        id = appInfoDTO.id,
        title = appInfoDTO.name,
        iconUrl = appInfoDTO.iconUrl,
        category = appInfoDTO.category,
        description = appInfoDTO.description
    )

    fun appInfoDTOtoAppInfo(appInfoDTO: AppInfoDTO): AppInfo = AppInfo(
        id = appInfoDTO.id,
        title = appInfoDTO.name,
        iconUrl = appInfoDTO.iconUrl,
        category = appInfoDTO.category,
        description = appInfoDTO.description
    )

    fun appDetailsEntityToAppDetails(appDetailsEntity: AppDetailsEntity): AppDetails =
        AppDetails(
            id = appDetailsEntity.id,
            title = appDetailsEntity.title,
            iconUrl = appDetailsEntity.iconUrl,
            category = appDetailsEntity.category,
            developer = appDetailsEntity.developer,
            ageRating = appDetailsEntity.ageRating,
            size = appDetailsEntity.size,
            screenshotsUrls = appDetailsEntity.screenshotsUrls,
            description = appDetailsEntity.description
        )

    fun appInfoEntityToAppInfo(appInfoEntity: AppInfoEntity): AppInfo = AppInfo(
        id = appInfoEntity.id,
        title = appInfoEntity.title,
        iconUrl = appInfoEntity.iconUrl,
        category = appInfoEntity.category,
        description = appInfoEntity.description
    )
}