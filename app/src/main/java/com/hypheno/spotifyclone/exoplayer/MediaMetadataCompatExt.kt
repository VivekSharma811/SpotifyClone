package com.hypheno.spotifyclone.exoplayer

import android.support.v4.media.MediaMetadataCompat
import com.hypheno.spotifyclone.data.entities.Song

fun MediaMetadataCompat.toSong(): Song? {
    return description?.let {
        Song(
            mediaId = it.mediaId ?: "",
            title = it.title.toString(),
            subtitle = it.subtitle.toString(),
            imageUrl = it.iconUri.toString(),
            songUrl = it.mediaUri.toString()
        )
    }
}