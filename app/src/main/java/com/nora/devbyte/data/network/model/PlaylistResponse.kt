package com.nora.devbyte.data.network.model

import com.squareup.moshi.JsonClass
import com.squareup.moshi.Json

@JsonClass(generateAdapter = true)
data class PlaylistResponse(
    @Json(name = "videos")
    val playlistNetworks: List<PlaylistNetwork>
)