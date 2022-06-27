package com.nora.devbyte.data.repository

import androidx.lifecycle.LiveData
import androidx.paging.*
import com.nora.devbyte.data.database.dao.PlaylistDao
import com.nora.devbyte.data.network.mapper.toDatabaseModel
import com.nora.devbyte.data.network.service.DevByteService
import com.nora.devbyte.data.paging.PlaylistPagingSource
import com.nora.devbyte.domain.model.Playlist
import com.nora.devbyte.domain.repository.PlaylistRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okio.IOException
import retrofit2.HttpException

class PlaylistRepositoryImpl(
    private val devByteService: DevByteService,
    private val playlistDao: PlaylistDao
) : PlaylistRepository {

    override suspend fun getDevBytePlaylist(): LiveData<PagingData<Playlist>> {
        return Pager(
            config = PagingConfig(
                pageSize = PAGE_SIZE,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                PlaylistPagingSource(devByteService, playlistDao)
            }
        ).liveData
    }

    companion object {
        const val PAGE_SIZE = 20
    }
}