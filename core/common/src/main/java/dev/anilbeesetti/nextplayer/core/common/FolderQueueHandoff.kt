package dev.anilbeesetti.nextplayer.core.common

/**
 * Hands the folder screen's visible video order to the player, so a tap from a folder starts
 * with its full queue instead of the player querying the folder again.
 */
object FolderQueueHandoff {

    data class Entry(val uri: String, val title: String)

    private var pending: Pair<String, List<Entry>>? = null

    @Synchronized
    fun offer(selectedUri: String, entries: List<Entry>) {
        pending = selectedUri to entries
    }

    /** Returns the offered queue once, and only for the video it was offered for. */
    @Synchronized
    fun take(selectedUri: String): List<Entry>? {
        val (offeredFor, entries) = pending ?: return null
        pending = null
        return entries.takeIf { offeredFor == selectedUri && entries.any { it.uri == selectedUri } }
    }
}
