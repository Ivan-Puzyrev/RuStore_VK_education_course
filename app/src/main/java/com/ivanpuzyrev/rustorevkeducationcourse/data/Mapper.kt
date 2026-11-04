package com.ivanpuzyrev.rustorevkeducationcourse.data

import com.ivanpuzyrev.rustorevkeducationcourse.domain.AppDetails
import com.ivanpuzyrev.rustorevkeducationcourse.domain.AppInfo
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Mapper @Inject constructor() {

    fun appDetailsDTOtoAppDetails(appDetailsDTO: AppDetailsDTO): AppDetails = AppDetails(
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

    fun appInfoDTOtoAppInfo(appInfoDTO: AppInfoDTO): AppInfo = AppInfo(
        id = appInfoDTO.id,
        title = appInfoDTO.name,
        iconUrl = appInfoDTO.iconUrl,
        category = appInfoDTO.category,
        description = appInfoDTO.description
    )
}