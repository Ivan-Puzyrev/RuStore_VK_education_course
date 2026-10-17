package com.ivanpuzyrev.rustorevkeducationcourse.domain

data class App(
    val id: Int,
    val title: String,
    val iconUrl: String,
    val category: Category,
    val developer: String,
    val ageLimit: Int,
    val size: Int,
    val screenshotsUrls: List<String>,
    val description: String
)

enum class Category {
    ENTERTAINMENT,
    COMMUNICATION,
    SERVICES,
    FINANCE,
    SHOPPING,
    GOVERNMENT,
    MAPS
}