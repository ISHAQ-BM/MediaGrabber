package com.example.mediagrabber.data.source.remote.model


import com.squareup.moshi.Json

data class SoundCloudDownloaderResponse(
    @field:Json(name = "download_url")
    val downloadUrl: String,
    @field:Json(name = "thumbnail")
    val thumbnail: String,
    @field:Json(name = "title")
    val title: String
)