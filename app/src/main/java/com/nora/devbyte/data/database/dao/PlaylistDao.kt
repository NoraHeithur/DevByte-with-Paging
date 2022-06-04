package com.nora.devbyte.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.nora.devbyte.data.database.entity.PlaylistEntity

@Dao
interface PlaylistDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPlaylist(playlist: List<PlaylistEntity>)

    @Query("SELECT * FROM devbyte_playlist_table")
    suspend fun getPlaylist(): List<PlaylistEntity>

    @Query("DELETE FROM devbyte_playlist_table")
    suspend fun clearPlaylist()
}