package com.ivanpuzyrev.rustorevkeducationcourse.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [AppDetailsEntity::class, AppInfoEntity::class], version = 1)
@TypeConverters(StringListConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getAppDAO(): AppDAO
}