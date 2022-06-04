package com.nora.devbyte.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.nora.devbyte.domain.model.Playlist

@Entity(tableName = "devbyte_playlist_table")
data class PlaylistEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val description: String,
    val thumbnail: String,
    val title: String,
    val updated: String,
    val url: String
)