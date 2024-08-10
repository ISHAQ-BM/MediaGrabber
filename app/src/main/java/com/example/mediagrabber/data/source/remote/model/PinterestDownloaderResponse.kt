package com.example.mediagrabber.data.source.remote.model


import com.squareup.moshi.Json

data class PinterestDownloaderResponse(
    @field:Json(name = "download_links")
    val downloadLinks: List<DownloadLink>,
    @field:Json(name = "thumbnail")
    val thumbnail: String,
    @field:Json(name = "title")
    val title: String
)