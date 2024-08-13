package com.example.mediagrabber.data.source.remote.model


import com.squareup.moshi.Json

data class DownloadResponse(
    @field:Json(name = "links")
    val links: List<Link>,
    @field:Json(name = "picture")
    val picture: String,
    @field:Json(name = "title")
    val title: String
)