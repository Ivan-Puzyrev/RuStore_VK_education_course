package com.ivanpuzyrev.rustorevkeducationcourse.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "app_info_entities")
data class AppInfoEntity(
    @PrimaryKey
    val id: String,
    val title: String,
    val iconUrl: String,
    val category: String,
    val description: String
)
