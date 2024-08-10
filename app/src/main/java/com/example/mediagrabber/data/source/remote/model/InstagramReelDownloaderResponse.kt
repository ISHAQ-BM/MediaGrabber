package com.example.mediagrabber.data.source.remote.model


import com.squareup.moshi.Json

data class InstagramReelDownloaderResponse(
    @field:Json(name = "thumb")
    val thumb: String,
    @field:Json(name = "title")
    val title: String,
    @field:Json(name = "url")
    val url: String
)