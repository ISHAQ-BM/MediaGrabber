package com.example.mediagrabber.data.source.remote.model


import com.squareup.moshi.Json

data class DownloadLink(
    @field:Json(name = "quality")
    val quality: String,
    @field:Json(name = "url")
    val url: String
)