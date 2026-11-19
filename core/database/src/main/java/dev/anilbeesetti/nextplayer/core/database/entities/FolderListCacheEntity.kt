package dev.anilbeesetti.nextplayer.core.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/** The last list a folder screen showed, so it can be shown instantly on the next open. */
@Entity(tableName = "folder_list_cache")
data class FolderListCacheEntity(
    @PrimaryKey
    @ColumnInfo(name = "key") val key: String,
    @ColumnInfo(
        name = "data",
        typeAffinity = ColumnInfo.BLOB,
    )
    val data: ByteArray,
)
