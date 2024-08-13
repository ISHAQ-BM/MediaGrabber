package com.example.mediagrabber.core

import android.app.DownloadManager
import android.content.Context
import android.os.Environment
import androidx.core.net.toUri

class Downloader(
    private val context: Context
) {

    private val downloadManager = context.getSystemService(DownloadManager::class.java)

    fun downloadFile(url: String): Long {
        val request = DownloadManager.Request(url.toUri())
            .setMimeType("video/mp4")
            .setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI)
            .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
            .setTitle("video.mp4")
            .setDestinationInExternalFilesDir(context, Environment.DIRECTORY_DOWNLOADS, "video.mp4")

        return downloadManager.enqueue(request)
    }

}