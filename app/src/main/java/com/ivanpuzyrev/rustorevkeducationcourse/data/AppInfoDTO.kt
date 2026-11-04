package com.ivanpuzyrev.rustorevkeducationcourse.data

import com.google.gson.annotations.SerializedName

data class AppInfoDTO(
    @SerializedName("category")
    val category: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("iconUrl")
    val iconUrl: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String
)