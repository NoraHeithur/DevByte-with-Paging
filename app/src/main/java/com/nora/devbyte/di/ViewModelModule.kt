package com.nora.devbyte.di

import com.nora.devbyte.domain.repository.PlaylistRepository
import com.nora.devbyte.ui.details.VideoDetailsViewModel
import com.nora.devbyte.ui.playlist.PlaylistViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { PlaylistViewModel(get() as PlaylistRepository) }
    viewModel { VideoDetailsViewModel() }
}