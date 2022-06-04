package com.nora.devbyte.data.network.service

import com.nora.devbyte.data.network.model.PlaylistResponse
import retrofit2.Response
import retrofit2.http.GET

interface DevByteService {

    @GET("devbytes.json")
    suspend fun getVideoPlaylistAsync(): Response<PlaylistResponse>
}