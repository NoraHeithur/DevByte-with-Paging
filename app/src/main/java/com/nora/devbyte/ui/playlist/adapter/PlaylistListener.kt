package com.nora.devbyte.ui.playlist.adapter

import android.view.View
import com.nora.devbyte.domain.model.Playlist

interface PlaylistListener {
    fun onItemClicked(view: View, playlist: Playlist)
}