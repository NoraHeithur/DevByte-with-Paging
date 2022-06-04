package com.nora.devbyte.domain.model

import android.net.Uri
import android.os.Parcelable
import com.nora.devbyte.ui.utils.DateUtil
import com.nora.devbyte.ui.utils.truncate
import kotlinx.parcelize.Parcelize

@Parcelize
data class Playlist(
    val id: Int,
    val description: String,
    val thumbnail: String,
    val title: String,
    val updated: String,
    val url: String
) : Parcelable {
    fun shortDescription() = description.truncate(200)

    fun updatedTimeElapsed() = DateUtil.convertToTimeElapsed(updated)

    fun getUri(url: String): Uri = Uri.parse(url)

    fun getYoutubeSchemeUri(url: String): Uri {
        val youtubeScheme = "vnd.youtube:"
        val httpUrl = Uri.parse(url)
        return Uri.parse("$youtubeScheme${httpUrl.getQueryParameter("v")}")
    }
}