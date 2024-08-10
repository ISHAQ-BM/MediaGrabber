package com.example.mediagrabber.data.source.remote.model


import com.squareup.moshi.Json

data class LinkedInDownloaderResponse(
    @field:Json(name = "formats")
    val formats: List<LinkedInFormat>,
    @field:Json(name = "thumbnail")
    val thumbnail: String,
    @Json(name = "title")
    val title: String
)