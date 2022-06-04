package com.nora.devbyte.di

import androidx.room.Room
import com.nora.devbyte.data.database.db.AppDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

private const val DATABASE_NAME = "DevByte_Database"

val databaseModule = module {
    single {
        Room.databaseBuilder(
            androidApplication(),
            AppDatabase::class.java,
            DATABASE_NAME
        ).build()
    }
    single { get<AppDatabase>().playlistDao() }
}