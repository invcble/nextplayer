package dev.anilbeesetti.nextplayer.core.data.repository

import dev.anilbeesetti.nextplayer.core.database.dao.FolderListCacheDao
import dev.anilbeesetti.nextplayer.core.database.entities.FolderListCacheEntity
import dev.anilbeesetti.nextplayer.core.model.Folder
import dev.anilbeesetti.nextplayer.core.model.Video
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.ObjectInputStream
import java.io.ObjectOutputStream
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.koin.core.annotation.Single

/** Persists the last list each folder screen showed, so reopening shows it before the query. */
@Single
class FolderListCache(private val dao: FolderListCacheDao) {

    data class Entry(val videos: List<Video>, val folders: List<Folder>)

    /** Returns null when nothing is cached or the cache was written by an older model. */
    suspend fun read(key: String): Entry? = withContext(Dispatchers.IO) {
        val data = dao.get(key = key)?.data ?: return@withContext null
        try {
            ObjectInputStream(ByteArrayInputStream(data)).use { input ->
                @Suppress("UNCHECKED_CAST")
                Entry(
                    videos = input.readObject() as List<Video>,
                    folders = input.readObject() as List<Folder>,
                )
            }
        } catch (_: Exception) {
            null
        }
    }

    suspend fun write(key: String, entry: Entry) = withContext(Dispatchers.IO) {
        val bytes = ByteArrayOutputStream().use { buffer ->
            ObjectOutputStream(buffer).use { output ->
                output.writeObject(ArrayList(entry.videos))
                output.writeObject(ArrayList(entry.folders))
            }
            buffer.toByteArray()
        }
        dao.upsert(
            FolderListCacheEntity(
                key = key,
                data = bytes,
            ),
        )
    }
}
