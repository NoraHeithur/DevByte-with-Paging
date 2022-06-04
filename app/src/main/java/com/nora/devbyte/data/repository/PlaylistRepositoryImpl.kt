package com.nora.devbyte.data.repository

import androidx.lifecycle.LiveData
import androidx.paging.*
import com.nora.devbyte.data.database.dao.PlaylistDao
import com.nora.devbyte.data.database.mapper.toDomainModel
import com.nora.devbyte.data.network.mapper.toDatabaseModel
import com.nora.devbyte.data.network.model.PlaylistResponse
import com.nora.devbyte.data.network.service.DevByteService
import com.nora.devbyte.data.paging.PlaylistPagingSource
import com.nora.devbyte.domain.model.Playlist
import com.nora.devbyte.domain.repository.PlaylistRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import okio.IOException
import retrofit2.HttpException
import timber.log.Timber
import java.net.UnknownHostException

class PlaylistRepositoryImpl(
    private val devByteService: DevByteService,
    private val playlistDao: PlaylistDao
) : PlaylistRepository {

    override suspend fun getDevBytePlaylistResponse() {
        withContext(Dispatchers.Default) {
            try {
                val playlistDb = playlistDao.getPlaylist()
                val playlistService = devByteService.getVideoPlaylistAsync()
                val playlistResponse = playlistService.body()
                val playlist = playlistResponse?.playlistNetworks
                playlist?.map { playlistNetwork ->
                    playlistNetwork.toDatabaseModel()
                }?.apply {
                    when (playlistDb.isEmpty()) {
                        true -> {
                            playlistDao.insertPlaylist(this)
                        }
                        false -> {
                            if (playlistDb.size < playlist.size) {
                                playlistDao.clearPlaylist()
                                playlistDao.insertPlaylist(this)
                            }
                        }
                    }
                }
            } catch (e: HttpException) {
                e.message()
            } catch (e: IOException) {
                e.message
            }
        }
    }

    override suspend fun getDevBytePlaylist(): LiveData<PagingData<Playlist>> {
        return Pager(
            config = PagingConfig(
                pageSize = PAGE_SIZE,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                PlaylistPagingSource(playlistDao)
            }
        ).liveData
    }

    companion object {
        const val PAGE_SIZE = 20
    }
}