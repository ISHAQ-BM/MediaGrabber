package com.example.mediagrabber.data.source.remote.api

import com.example.mediagrabber.data.source.remote.model.FacebookDownloaderResponse
import com.example.mediagrabber.data.source.remote.model.InstagramDownloaderRequestBody
import com.example.mediagrabber.data.source.remote.model.LinkedInDownloaderResponse
import com.example.mediagrabber.data.source.remote.model.PinterestDownloaderResponse
import com.example.mediagrabber.data.source.remote.model.SoundCloudDownloaderResponse
import com.example.mediagrabber.data.source.remote.model.TikTokDownloaderResponse
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Streaming
import retrofit2.http.Url

interface MediaGrabberApiService {

    @POST("fbloader.php")
    suspend fun getFacebookDownloadableUrl(
        @Body url: String
    ): Response<FacebookDownloaderResponse>

    @POST("ytloader.php")
    suspend fun getYoutubeDownloadableUrl(
        @Body url: String
    ): Response<FacebookDownloaderResponse>

    @POST("insta.php")
    suspend fun getInstagramDownloadableUrl(
        @Body instagramDownloaderRequestBody: InstagramDownloaderRequestBody
    ): Response<FacebookDownloaderResponse>

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

    @Streaming
    @GET
    suspend fun downloadFile(@Url fileUrl: String): Response<ResponseBody>


}