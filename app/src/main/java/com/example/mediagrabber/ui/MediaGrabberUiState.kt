package com.example.mediagrabber.ui

data class MediaGrabberUiState(
    val links: Map<String, String> = emptyMap(),
    val imageUrl: String = "",
    val title: String = "",
    val isLoading: Boolean = false
)
