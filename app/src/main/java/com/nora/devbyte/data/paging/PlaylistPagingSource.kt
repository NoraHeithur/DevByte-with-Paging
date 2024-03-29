package com.nora.devbyte.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.nora.devbyte.data.database.dao.PlaylistDao
import com.nora.devbyte.data.database.mapper.toDomainModel
import com.nora.devbyte.data.network.mapper.toDatabaseModel
import com.nora.devbyte.data.network.service.DevByteService
import com.nora.devbyte.domain.model.Playlist
import retrofit2.HttpException
import timber.log.Timber
import java.io.IOException

class PlaylistPagingSource(
    private val service: DevByteService,
    private val playlistDao: PlaylistDao
) : PagingSource<Int, Playlist>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Playlist> {
        return try {
            val playlistDb = playlistDao.getPlaylist()

            val playlistService = service.getVideoPlaylistAsync()
            val playlistResponse = playlistService.body()
            val playlistResult = playlistResponse?.playlistNetworks

            playlistResult?.map { playlistNetwork ->
                playlistNetwork.toDatabaseModel()
            }?.apply {
                when (playlistDb.isEmpty()) {
                    true -> {
                        playlistDao.insertPlaylist(this)
                    }
                    false -> {
                        if (playlistDb.size < playlistResult.size) {
                            playlistDao.clearPlaylist()
                            playlistDao.insertPlaylist(this)
                        }
                    }
                }
            }

            val playlist = if (playlistDao.getPlaylist().isNotEmpty()) {
                playlistDao.getPlaylist().map { it.toDomainModel() }
            } else {
                emptyList()
            }
            LoadResult.Page(
                data = playlist,
                // prevKey = null for paging forward.
                prevKey = null,
                // nextKey = null, because Devbyte service has only one data list.
                nextKey = null
            )
        } catch (e: IOException) {
            return LoadResult.Error(e)
        } catch (e: HttpException) {
            return LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Playlist>): Int? {
        return null
    }
}