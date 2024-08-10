package com.example.mediagrabber.data.source.remote.model


import com.squareup.moshi.Json


data class FacebookDownloaderResponse(
    @field:Json(name = "audio_type")
    val audioType: String,
    @field:Json(name = "audio_url")
    val audioUrl: String,
    @field:Json(name = "thumbnail")
    val thumbnail: String,
    @Json(name = "title")
    val title: String,
    @field:Json(name = "video_qualities")
    val videoQualities: List<VideoQuality>
)