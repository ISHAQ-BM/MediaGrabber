package com.example.mediagrabber.data.source.remote.model


import com.squareup.moshi.Json

data class InstagramDownloaderRequestBody(
    @field:Json(name = "type")
    val type: String,
    @field:Json(name = "url")
    val url: String
)