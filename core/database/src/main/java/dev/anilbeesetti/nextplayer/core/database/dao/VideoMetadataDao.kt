package dev.anilbeesetti.nextplayer.core.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import dev.anilbeesetti.nextplayer.core.database.entities.VideoMetadataEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface VideoMetadataDao {

    @Query("SELECT * FROM video_metadata")
    fun observeAll(): Flow<List<VideoMetadataEntity>>

    @Query("SELECT * FROM video_metadata")
    suspend fun getAll(): List<VideoMetadataEntity>

    @Query("SELECT * FROM video_metadata WHERE uri = :uriString")
    suspend fun get(uriString: String): VideoMetadataEntity?

    @Upsert
    suspend fun upsert(metadata: VideoMetadataEntity)

    @Upsert
    suspend fun upsertAll(metadata: List<VideoMetadataEntity>)

    @Query("DELETE FROM video_metadata WHERE uri IN (:uriStrings)")
    suspend fun deleteByUris(uriStrings: List<String>)
}
