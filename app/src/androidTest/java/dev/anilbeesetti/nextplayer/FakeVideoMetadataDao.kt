package dev.anilbeesetti.nextplayer

import dev.anilbeesetti.nextplayer.core.database.dao.VideoMetadataDao
import dev.anilbeesetti.nextplayer.core.database.entities.VideoMetadataEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update

class FakeVideoMetadataDao : VideoMetadataDao {
    private val rows = MutableStateFlow(emptyMap<String, VideoMetadataEntity>())

    override fun observeAll(): Flow<List<VideoMetadataEntity>> = rows.map { it.values.toList() }

    override suspend fun getAll(): List<VideoMetadataEntity> = rows.value.values.toList()

    override suspend fun get(uriString: String): VideoMetadataEntity? = rows.value[uriString]

    override suspend fun upsert(metadata: VideoMetadataEntity) = upsertAll(listOf(metadata))

    override suspend fun upsertAll(metadata: List<VideoMetadataEntity>) {
        rows.update { current -> current + metadata.associateBy { it.uriString } }
    }

    override suspend fun deleteByUris(uriStrings: List<String>) {
        rows.update { current -> current - uriStrings.toSet() }
    }
}
