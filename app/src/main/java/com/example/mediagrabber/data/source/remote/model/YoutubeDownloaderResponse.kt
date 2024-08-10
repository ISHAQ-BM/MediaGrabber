package com.example.mediagrabber.data.source.remote.model


import com.squareup.moshi.Json

data class YoutubeDownloaderResponse(
    @field:Json(name = "formats")
    val youtubeFormats: List<YoutubeFormat>,
    @field:Json(name = "thumbnail")
    val thumbnail: String,
    @field:Json(name = "title")
    val title: String
)