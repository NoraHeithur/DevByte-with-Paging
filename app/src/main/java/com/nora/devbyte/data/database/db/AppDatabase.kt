package com.nora.devbyte.data.database.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.nora.devbyte.data.database.dao.PlaylistDao
import com.nora.devbyte.data.database.entity.PlaylistEntity

@Database(entities = [PlaylistEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun playlistDao(): PlaylistDao
}