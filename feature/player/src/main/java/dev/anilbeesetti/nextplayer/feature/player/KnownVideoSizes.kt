package dev.anilbeesetti.nextplayer.feature.player

import androidx.compose.ui.geometry.Size

/**
 * Video sizes already known from the media library, keyed by media id. The player surface uses
 * them until the decoder reports the real size, so the first frame is laid out at the right
 * shape instead of full screen (androidx/media#3238).
 */
internal object KnownVideoSizes {
    private val sizes = mutableMapOf<String, Size>()

    @Synchronized
    fun put(mediaId: String, width: Int, height: Int) {
        if (width <= 0 || height <= 0) return
        sizes[mediaId] = Size(
            width = width.toFloat(),
            height = height.toFloat(),
        )
    }

    @Synchronized
    fun get(mediaId: String): Size? = sizes[mediaId]
}
