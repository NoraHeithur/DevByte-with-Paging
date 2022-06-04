package com.nora.devbyte.ui.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nora.devbyte.domain.model.Playlist

class VideoDetailsViewModel: ViewModel() {

    private val _video = MutableLiveData<Playlist>()
    val video: LiveData<Playlist> = _video

    fun getVideo(video: Playlist) {
        _video.value = video
    }
}