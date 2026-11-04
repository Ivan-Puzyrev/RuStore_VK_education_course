package com.ivanpuzyrev.rustorevkeducationcourse.data

import com.google.gson.annotations.SerializedName

data class AppDetailsDTO(
    @SerializedName("ageRating")
    val ageRating: Int,
    @SerializedName("category")
    val category: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("developer")
    val developer: String,
    @SerializedName("iconUrl")
    val iconUrl: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("screenshotUrlList")
    val screenshotUrlList: List<String>,
    @SerializedName("size")
    val size: Double
)