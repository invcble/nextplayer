package dev.anilbeesetti.nextplayer.core.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Metadata probed from the file for videos MediaStore indexed without it.
 * A failed probe is stored as zeros so the file is not probed again until it changes.
 */
@Entity(tableName = "video_metadata")
data class VideoMetadataEntity(
    @PrimaryKey
    @ColumnInfo(name = "uri") val uriString: String,
    @ColumnInfo(name = "size") val size: Long,
    @ColumnInfo(name = "date_modified") val dateModified: Long,
    @ColumnInfo(name = "duration") val duration: Long,
    @ColumnInfo(name = "width") val width: Int,
    @ColumnInfo(name = "height") val height: Int,
)
