package com.nora.devbyte.ui.playlist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.nora.devbyte.databinding.PlaylistListItemBinding
import com.nora.devbyte.domain.model.Playlist

class PlaylistAdapter(private val listener: PlaylistListener) :
    PagingDataAdapter<Playlist, PlaylistAdapter.PlaylistViewHolder>(
        PlaylistComparator
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaylistViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val bindingLayout = PlaylistListItemBinding.inflate(inflater, parent, false)

        return PlaylistViewHolder(bindingLayout)
    }

    override fun onBindViewHolder(holder: PlaylistViewHolder, position: Int) {
        getItem(position)?.let { holder.bindView(it, listener) }
    }

    inner class PlaylistViewHolder(private val itemBinding: PlaylistListItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

        fun bindView(item: Playlist, listener: PlaylistListener) {
            itemBinding.playlistItem = item
            itemBinding.playlistListener = listener
            itemBinding.executePendingBindings()
        }
    }

    object PlaylistComparator: DiffUtil.ItemCallback<Playlist>() {
        override fun areItemsTheSame(oldItem: Playlist, newItem: Playlist): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Playlist, newItem: Playlist): Boolean {
            return oldItem.id == newItem.id
        }
    }
}