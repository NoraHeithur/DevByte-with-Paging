package com.nora.devbyte.data.network.mapper

import com.nora.devbyte.data.database.entity.PlaylistEntity
import com.nora.devbyte.data.network.model.PlaylistNetwork
import com.nora.devbyte.domain.model.Playlist
import org.joda.time.DateTime

fun PlaylistNetwork.toDatabaseModel(): PlaylistEntity {
    return PlaylistEntity(
        description = description,
        thumbnail = thumbnail,
        title = title,
        updated = updated,
        url = url
    )
}
