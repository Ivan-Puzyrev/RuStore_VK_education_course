package com.ivanpuzyrev.rustorevkeducationcourse.data

import com.ivanpuzyrev.rustorevkeducationcourse.domain.App
import com.ivanpuzyrev.rustorevkeducationcourse.domain.Category as DomainCategory

class Mapper {

    fun appDTOtoDomainApp(appDTO: AppDTO): App = App(
        id = appDTO.id,
        title = appDTO.title,
        iconUrl = appDTO.iconUrl,
        category = appDTO.category.toDomainCategory(),
        developer = appDTO.developer,
        ageLimit = appDTO.ageLimit,
        size = appDTO.size,
        screenshotsUrls = appDTO.screenshotsUrls,
        description = appDTO.description
    )

    private fun Category.toDomainCategory(): DomainCategory = when (this) {
        Category.ENTERTAINMENT -> DomainCategory.ENTERTAINMENT
        Category.COMMUNICATION -> DomainCategory.COMMUNICATION
        Category.SERVICES -> DomainCategory.SERVICES
        Category.FINANCE -> DomainCategory.FINANCE
        Category.SHOPPING -> DomainCategory.SHOPPING
        Category.GOVERNMENT -> DomainCategory.GOVERNMENT
        Category.MAPS -> DomainCategory.MAPS
    }

}