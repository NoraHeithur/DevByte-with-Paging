package com.nora.devbyte.ui.playlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.*
import com.nora.devbyte.domain.model.Playlist
import com.nora.devbyte.domain.repository.PlaylistRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import timber.log.Timber

class PlaylistViewModel(private val playlistRepository: PlaylistRepository) : ViewModel() {

    suspend fun getPlaylistLiveData(): LiveData<PagingData<Playlist>> {
        return playlistRepository.getDevBytePlaylist().cachedIn(viewModelScope)
    }
}