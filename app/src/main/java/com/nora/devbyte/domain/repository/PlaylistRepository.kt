package com.nora.devbyte.domain.repository

import androidx.lifecycle.LiveData
import androidx.paging.PagingData
import com.nora.devbyte.data.paging.PlaylistPagingSource
import com.nora.devbyte.domain.model.Playlist
import kotlinx.coroutines.flow.Flow

interface PlaylistRepository {

    suspend fun getDevBytePlaylist() : LiveData<PagingData<Playlist>>
}