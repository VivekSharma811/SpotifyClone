package com.hypheno.spotifyclone.data.remote

import com.google.firebase.firestore.FirebaseFirestore
import com.hypheno.spotifyclone.data.entities.Song
import com.hypheno.spotifyclone.other.Constant.SONG_COLLECTION
import kotlinx.coroutines.tasks.await
import java.lang.Exception

class MusicDatabase {

    private val firestore = FirebaseFirestore.getInstance()
    private val songCollection = firestore.collection(SONG_COLLECTION)

    suspend fun getAllSongs(): List<Song> {
        return try {
            songCollection.get().await().toObjects(Song::class.java)
        } catch (e: Exception) {
            emptyList()
        }
    }
}