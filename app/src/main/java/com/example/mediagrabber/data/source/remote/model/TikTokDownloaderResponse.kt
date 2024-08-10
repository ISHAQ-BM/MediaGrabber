package com.example.mediagrabber.data.source.remote.model


import com.squareup.moshi.Json

data class TikTokDownloaderResponse(
    @field:Json(name = "downloadUrls")
    val downloadUrls: List<DownloadUrl>,
    @field:Json(name = "thumbnail")
    val thumbnail: String
)