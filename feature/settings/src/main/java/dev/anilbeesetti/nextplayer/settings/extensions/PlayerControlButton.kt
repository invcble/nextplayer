package dev.anilbeesetti.nextplayer.settings.extensions

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import dev.anilbeesetti.nextplayer.core.model.PlayerControlButton
import dev.anilbeesetti.nextplayer.core.ui.R

@Composable
fun PlayerControlButton.name(): String {
    val stringRes = when (this) {
        PlayerControlButton.DECODER -> R.string.player_button_decoder
        PlayerControlButton.PLAYLIST -> R.string.player_button_playlist
        PlayerControlButton.AUDIO_TRACK -> R.string.player_button_audio_track
        PlayerControlButton.SUBTITLE -> R.string.player_button_subtitle
        PlayerControlButton.CHAPTERS -> R.string.player_button_chapters
        PlayerControlButton.PLAYBACK_SPEED -> R.string.player_button_playback_speed
        PlayerControlButton.ROTATE -> R.string.player_button_rotate
        PlayerControlButton.LOCK -> R.string.player_button_lock
        PlayerControlButton.CONTENT_SCALE -> R.string.player_button_content_scale
        PlayerControlButton.PICTURE_IN_PICTURE -> R.string.player_button_picture_in_picture
        PlayerControlButton.BACKGROUND_PLAY -> R.string.player_button_background_play
        PlayerControlButton.LOOP -> R.string.player_button_loop
        PlayerControlButton.SHUFFLE -> R.string.player_button_shuffle
    }

    return stringResource(id = stringRes)
}
