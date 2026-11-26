package com.ivanpuzyrev.rustorevkeducationcourse.data.db

import androidx.room.TypeConverter
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.json.Json

class StringListConverter {
    @TypeConverter
    fun fromList(value: List<String>): String =
        Json.encodeToString(ListSerializer(String.serializer()), value)

    @TypeConverter
    fun toList(value: String): List<String> =
        Json.decodeFromString(ListSerializer(String.serializer()), value)
}