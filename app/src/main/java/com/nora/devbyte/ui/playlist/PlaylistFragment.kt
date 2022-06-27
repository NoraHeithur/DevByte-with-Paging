package com.nora.devbyte.ui.playlist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.doOnNextLayout
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.transition.MaterialElevationScale
import com.nora.devbyte.R
import com.nora.devbyte.databinding.FragmentPlaylistBinding
import com.nora.devbyte.domain.model.Playlist
import com.nora.devbyte.ui.playlist.adapter.PlaylistAdapter
import com.nora.devbyte.ui.playlist.adapter.PlaylistListener
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class PlaylistFragment : Fragment(), PlaylistListener {

    private val binding: FragmentPlaylistBinding by lazy {
        FragmentPlaylistBinding.inflate(layoutInflater)
    }

    private val viewModel: PlaylistViewModel by viewModel()

    private fun bindingRecyclerView() {
        val playlistAdapter = PlaylistAdapter(this)
        binding.devBytePlayListRv.apply {
            layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
            adapter = playlistAdapter.apply {
                doOnNextLayout {
                    bindingData(playlistAdapter)
                    doOnNextLayout {
                        startPostponedEnterTransition()
                    }
                }

                binding.swipePlaylist.setOnRefreshListener {
                    refresh()
                }
            }
        }
        postponeEnterTransition()
    }

    private fun bindingData(adapter: PlaylistAdapter) {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.getPlaylistLiveData().observe(viewLifecycleOwner) { playlist ->
                adapter.submitData(lifecycle, playlist)
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            adapter.loadStateFlow.collectLatest { state ->
                binding.swipePlaylist.isRefreshing = state.refresh is LoadState.Loading
            }
        }
    }

    override fun onItemClicked(view: View, playlist: Playlist) {

        exitTransition = MaterialElevationScale(false).apply {
            duration = resources.getInteger(R.integer.motion_duration_normal).toLong()
        }
        reenterTransition = MaterialElevationScale(true).apply {
            duration = resources.getInteger(R.integer.motion_duration_normal).toLong()
        }

        val videoItemTransition = getString(R.string.video_details_card_transition_name)
        val extras = FragmentNavigatorExtras(view to videoItemTransition)
        val directions =
            PlaylistFragmentDirections.actionPlaylistFragmentToVideoDetailsFragment(playlist)

        findNavController().navigate(directions, extras)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding.lifecycleOwner = viewLifecycleOwner

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindingRecyclerView()
    }
}