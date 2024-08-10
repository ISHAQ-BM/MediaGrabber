package com.example.mediagrabber.data.source.remote.model


import com.squareup.moshi.Json

data class YoutubeFormat(
    @field:Json(name = "default_selected")
    val defaultSelected: Int,
    @field:Json(name = "height")
    val height: Int,
    @field:Json(name = "label")
    val label: String,
    @field:Json(name = "quality")
    val quality: Int,
    @field:Json(name = "url")
    val url: String,
    @field:Json(name = "width")
    val width: Int
)