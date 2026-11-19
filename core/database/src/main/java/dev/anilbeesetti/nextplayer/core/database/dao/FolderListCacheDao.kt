package dev.anilbeesetti.nextplayer.core.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import dev.anilbeesetti.nextplayer.core.database.entities.FolderListCacheEntity

@Dao
interface FolderListCacheDao {

    @Query("SELECT * FROM folder_list_cache WHERE `key` = :key")
    suspend fun get(key: String): FolderListCacheEntity?

    @Upsert
    suspend fun upsert(entry: FolderListCacheEntity)
}
