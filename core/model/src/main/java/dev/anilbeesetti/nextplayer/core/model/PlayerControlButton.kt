package dev.anilbeesetti.nextplayer.core.model

import kotlinx.serialization.Serializable

/** Optional player control buttons that can be hidden from settings. */
@Serializable
enum class PlayerControlButton {
    DECODER,
    PLAYLIST,
    AUDIO_TRACK,
    SUBTITLE,
    CHAPTERS,
    PLAYBACK_SPEED,
    ROTATE,
    LOCK,
    CONTENT_SCALE,
    PICTURE_IN_PICTURE,
    BACKGROUND_PLAY,
    LOOP,
    SHUFFLE,
}
