package com.nora.devbyte.data.network.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PlaylistNetwork(
    @Json(name = "description")
    val description: String,
    @Json(name = "thumbnail")
    val thumbnail: String,
    @Json(name = "title")
    val title: String,
    @Json(name = "updated")
    val updated: String,
    @Json(name = "url")
    val url: String
)
