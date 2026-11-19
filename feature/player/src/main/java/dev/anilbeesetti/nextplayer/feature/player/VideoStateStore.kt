package dev.anilbeesetti.nextplayer.feature.player

import android.net.Uri
import dev.anilbeesetti.nextplayer.core.data.repository.MediaRepository

/** Per-video state writes, dropped entirely while "Remember per-video state" is off. */
internal class VideoStateStore(
    private val mediaRepository: MediaRepository,
    private val isEnabled: () -> Boolean,
) {
    suspend fun updateMediumLastPlayedTime(
        uri: String,
        lastPlayedTime: Long,
        duration: Long? = null,
    ) {
        if (!isEnabled()) return
        mediaRepository.updateMediumLastPlayedTime(
            uri = uri,
            lastPlayedTime = lastPlayedTime,
            duration = duration,
        )
    }

    suspend fun updateMediumPosition(uri: String, position: Long) {
        if (!isEnabled()) return
        mediaRepository.updateMediumPosition(
            uri = uri,
            position = position,
        )
    }

    suspend fun updateMediumAudioTrack(uri: String, audioTrackIndex: Int) {
        if (!isEnabled()) return
        mediaRepository.updateMediumAudioTrack(
            uri = uri,
            audioTrackIndex = audioTrackIndex,
        )
    }

    suspend fun updateMediumSubtitleTrack(uri: String, subtitleTrackIndex: Int) {
        if (!isEnabled()) return
        mediaRepository.updateMediumSubtitleTrack(
            uri = uri,
            subtitleTrackIndex = subtitleTrackIndex,
        )
    }

    suspend fun updateMediumZoom(uri: String, zoom: Float) {
        if (!isEnabled()) return
        mediaRepository.updateMediumZoom(
            uri = uri,
            zoom = zoom,
        )
    }

    suspend fun addExternalAudioToMedium(uri: String, audioUri: Uri) {
        if (!isEnabled()) return
        mediaRepository.addExternalAudioToMedium(
            uri = uri,
            audioUri = audioUri,
        )
    }

    suspend fun addExternalSubtitleToMedium(uri: String, subtitleUri: Uri) {
        if (!isEnabled()) return
        mediaRepository.addExternalSubtitleToMedium(
            uri = uri,
            subtitleUri = subtitleUri,
        )
    }

    suspend fun updateSubtitleDelay(uri: String, delay: Long) {
        if (!isEnabled()) return
        mediaRepository.updateSubtitleDelay(
            uri = uri,
            delay = delay,
        )
    }

    suspend fun updateSubtitleSpeed(uri: String, speed: Float) {
        if (!isEnabled()) return
        mediaRepository.updateSubtitleSpeed(
            uri = uri,
            speed = speed,
        )
    }
}
