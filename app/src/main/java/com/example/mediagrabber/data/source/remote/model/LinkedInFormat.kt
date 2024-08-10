package com.example.mediagrabber.data.source.remote.model


import com.squareup.moshi.Json

data class LinkedInFormat(
    @field:Json(name = "ext")
    val ext: String,
    @field:Json(name = "quality")
    val quality: String,
    @field:Json(name = "rate")
    val rate: Int,
    @field:Json(name = "url")
    val url: String
)