package com.ivanpuzyrev.rustorevkeducationcourse.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface AppDAO {

    @Insert
    suspend fun insertAppInfo(appInfoEntity: AppInfoEntity)

    @Insert
    suspend fun insertAppDetails(appDetailsEntity: AppDetailsEntity)

    @Query("SELECT * FROM app_info_entities")
    suspend fun getAppInfo(): List<AppInfoEntity>

    @Query("SELECT * FROM app_details_entities WHERE id = :id")
    fun getAppDetailsById(id: String): Flow<AppDetailsEntity?>

    @Query("UPDATE app_details_entities SET isInWishlist = NOT isInWishlist WHERE id = :id")
    suspend fun toggleWishlistStatus(id: String)
}