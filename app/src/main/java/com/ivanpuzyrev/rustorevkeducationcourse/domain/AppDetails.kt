package com.ivanpuzyrev.rustorevkeducationcourse.domain

data class AppDetails(
    val id: String,
    val title: String,
    val iconUrl: String,
    val category: String,
    val developer: String,
    val ageRating: Int,
    val size: Double,
    val screenshotsUrls: List<String>,
    val description: String
)