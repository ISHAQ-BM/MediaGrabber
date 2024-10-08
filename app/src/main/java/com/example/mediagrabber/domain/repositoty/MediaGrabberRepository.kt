package com.example.mediagrabber.domain.repositoty

import com.example.mediagrabber.core.Error
import com.example.mediagrabber.core.Result
import com.example.mediagrabber.data.source.remote.model.DownloadResponse
import kotlinx.coroutines.flow.Flow

interface MediaGrabberRepository {
    /*suspend fun getFacebookDownloadableUrl(url: String): Flow<Result<FacebookDownloaderResponse, Error>>
    suspend fun getInstagramReelDownloadableUrl(
        url: String,
        type: String
    ): Flow<Result<InstagramReelDownloaderResponse, Error>>

    suspend fun getInstagramPhotosDownloadableUrl(
        url: String,
        type: String
    ): Flow<Result<InstagramPhotosDownloaderResponse, Error>>

    suspend fun getYoutubeDownloadableUrl(url: String): Flow<Result<YoutubeDownloaderResponse, Error>>
    suspend fun getSoundCloudDownloadableUrl(url: String): Flow<Result<SoundCloudDownloaderResponse, Error>>
    suspend fun getTikTokDownloadableUrl(url: String): Flow<Result<TikTokDownloaderResponse, Error>>
    suspend fun getLinkedInDownloadableUrl(url: String): Flow<Result<LinkedInDownloaderResponse, Error>>
    suspend fun getPinterestDownloadableUrl(url: String): Flow<Result<PinterestDownloaderResponse, Error>>
*/

    suspend fun getDownloadableUrls(url: String): Flow<Result<DownloadResponse, Error>>

}