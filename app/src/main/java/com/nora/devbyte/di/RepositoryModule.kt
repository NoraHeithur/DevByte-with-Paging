package com.nora.devbyte.di

import com.nora.devbyte.data.database.dao.PlaylistDao
import com.nora.devbyte.data.network.service.DevByteService
import com.nora.devbyte.data.repository.PlaylistRepositoryImpl
import com.nora.devbyte.domain.repository.PlaylistRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<PlaylistRepository> {
        PlaylistRepositoryImpl(
            get() as DevByteService,
            get() as PlaylistDao
        )
    }
}