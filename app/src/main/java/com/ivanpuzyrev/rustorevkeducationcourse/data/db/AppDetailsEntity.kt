package com.ivanpuzyrev.rustorevkeducationcourse.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "app_details_entities")
data class AppDetailsEntity(
    @PrimaryKey
    val id: String,
    val title: String,
    val iconUrl: String,
    val category: String,
    val developer: String,
    val ageRating: Int,
    val size: Double,
    val screenshotsUrls: List<String>,
    val description: String,
    val isInWishlist: Boolean = false
)