package com.example.mediagrabber.data.source.remote.api

import com.example.mediagrabber.data.source.remote.model.FacebookDownloaderResponse
import com.example.mediagrabber.data.source.remote.model.InstagramDownloaderRequestBody
import com.example.mediagrabber.data.source.remote.model.InstagramPhotosDownloaderResponse
import com.example.mediagrabber.data.source.remote.model.InstagramReelDownloaderResponse
import com.example.mediagrabber.data.source.remote.model.LinkedInDownloaderResponse
import com.example.mediagrabber.data.source.remote.model.PinterestDownloaderResponse
import com.example.mediagrabber.data.source.remote.model.SoundCloudDownloaderResponse
import com.example.mediagrabber.data.source.remote.model.TikTokDownloaderResponse
import com.example.mediagrabber.data.source.remote.model.YoutubeDownloaderResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface MediaGrabberApiService {

    @POST("fbloader.php")
    suspend fun getFacebookDownloadableUrl(
        @Body url: String
    ): Response<FacebookDownloaderResponse>

    @POST("ytloader.php")
    suspend fun getYoutubeDownloadableUrl(
        @Body url: String
    ): Response<YoutubeDownloaderResponse>

    @POST("insta.php")
    suspend fun getInstagramPhotosDownloadableUrl(
        @Body instagramDownloaderRequestBody: InstagramDownloaderRequestBody
    ): Response<InstagramPhotosDownloaderResponse>

    @POST("insta.php")
    suspend fun getInstagramReelDownloadableUrl(
        @Body instagramDownloaderRequestBody: InstagramDownloaderRequestBody
    ): Response<InstagramReelDownloaderResponse>

    @POST("scloader.php")
    suspend fun getSoundCloudDownloadableUrl(
        @Body url: String
    ): Response<SoundCloudDownloaderResponse>

    @POST("tiktokloader.php")
    suspend fun getTikTokDownloadableUrl(
        @Body url: String
    ): Response<TikTokDownloaderResponse>

    @POST("linkedinloader.php")
    suspend fun getLinkedInDownloadableUrl(
        @Body url: String
    ): Response<LinkedInDownloaderResponse>

    @POST("pineterestloader.php")
    suspend fun getPinterestDownloadableUrl(
        @Body url: String
    ): Response<PinterestDownloaderResponse>



}