package com.nora.devbyte.data.database.mapper

import com.nora.devbyte.data.database.entity.PlaylistEntity
import com.nora.devbyte.domain.model.Playlist

fun PlaylistEntity.toDomainModel(): Playlist {
    return Playlist(
        id = id,
        description = description,
        thumbnail = thumbnail,
        title = title,
        updated = updated,
        url = url
    )
}