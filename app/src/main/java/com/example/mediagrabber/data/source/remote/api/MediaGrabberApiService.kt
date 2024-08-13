package com.example.mediagrabber.data.source.remote.api


import com.example.mediagrabber.BuildConfig
import com.example.mediagrabber.data.source.remote.model.DownloadResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface MediaGrabberApiService {

    /*@POST("fbloader.php")
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
    ): Response<PinterestDownloaderResponse>*/


    @GET("all")
    suspend fun getDownloadableUrls(
        @Query("url") url: String,
        @Header("x-rapidapi-host") host: String = "social-media-video-downloader.p.rapidapi.com",
        @Header("x-rapidapi-key") apiKey: String = BuildConfig.API_KEY
    ): Response<DownloadResponse>



}