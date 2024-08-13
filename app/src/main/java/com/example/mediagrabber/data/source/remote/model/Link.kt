package com.example.mediagrabber.data.source.remote.model


import com.squareup.moshi.Json

data class Link(
    @field:Json(name = "link")
    val link: String,
    @field:Json(name = "quality")
    val quality: String
)