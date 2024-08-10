package com.example.mediagrabber.data.source.remote.model


import com.squareup.moshi.Json

data class InstagramPhotosDownloaderResponse(
    @field:Json(name = "imageUrls")
    val imageUrls: List<String>
)