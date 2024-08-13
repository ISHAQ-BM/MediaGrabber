package com.example.mediagrabber.data.repository

import com.example.mediagrabber.core.Error
import com.example.mediagrabber.core.Result
import com.example.mediagrabber.data.source.remote.api.MediaGrabberApiService
import com.example.mediagrabber.data.source.remote.model.DownloadResponse
import com.example.mediagrabber.domain.repositoty.MediaGrabberRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class MediaGrabberRepositoryImpl @Inject constructor(
    private val mediaGrabberApiService: MediaGrabberApiService
) : MediaGrabberRepository {
    /* override suspend fun getFacebookDownloadableUrl(url: String): Flow<Result<FacebookDownloaderResponse, Error>> =
        safeApiCall { mediaGrabberApiService.getFacebookDownloadableUrl(url) }


    override suspend fun getInstagramReelDownloadableUrl(
        url: String,
        type: String
    ): Flow<Result<InstagramReelDownloaderResponse, Error>> = safeApiCall {
        mediaGrabberApiService.getInstagramReelDownloadableUrl(
            InstagramDownloaderRequestBody(type, url)
        )
    }

    override suspend fun getInstagramPhotosDownloadableUrl(
        url: String,
        type: String
    ): Flow<Result<InstagramPhotosDownloaderResponse, Error>> = safeApiCall {
        mediaGrabberApiService.getInstagramPhotosDownloadableUrl(
            InstagramDownloaderRequestBody(type, url)
        )
    }

    override suspend fun getYoutubeDownloadableUrl(url: String): Flow<Result<YoutubeDownloaderResponse, Error>> =
        safeApiCall { mediaGrabberApiService.getYoutubeDownloadableUrl(url) }

    override suspend fun getSoundCloudDownloadableUrl(url: String): Flow<Result<SoundCloudDownloaderResponse, Error>> =
        safeApiCall { mediaGrabberApiService.getSoundCloudDownloadableUrl(url) }

    override suspend fun getTikTokDownloadableUrl(url: String): Flow<Result<TikTokDownloaderResponse, Error>> =
        safeApiCall { mediaGrabberApiService.getTikTokDownloadableUrl(url) }

    override suspend fun getLinkedInDownloadableUrl(url: String): Flow<Result<LinkedInDownloaderResponse, Error>> =
        safeApiCall { mediaGrabberApiService.getLinkedInDownloadableUrl(url) }

    override suspend fun getPinterestDownloadableUrl(url: String): Flow<Result<PinterestDownloaderResponse, Error>> =
        safeApiCall { mediaGrabberApiService.getPinterestDownloadableUrl(url) }
*/
    override suspend fun getDownloadableUrls(url: String): Flow<Result<DownloadResponse, Error>> {
        return flow {
            try {
                val response = mediaGrabberApiService.getDownloadableUrls(url = url)
                if (response.isSuccessful) {
                    emit(Result.Success(response.body()!!))
                } else {
                    emit(Result.Error(Error.Network.SERVER_ERROR))
                }
            } catch (e: HttpException) {
                emit(Result.Error(Error.Network.NO_INTERNET))
            } catch (e: IOException) {
                emit(Result.Error(Error.Network.UNKNOWN))
            } catch (e: Exception) {
                emit(Result.Error(Error.Network.UNKNOWN))
            }
        }
    }


}
/*

abstract class BaseRepository {
    suspend fun <T> safeApiCall(apiToBeCalled: suspend () -> Response<T>): Flow<Result<T, Error>> =
        flow {
            try {
                val response = apiToBeCalled()
                if (response.isSuccessful) {
                    emit(Result.Success(response.body()!!))
                } else {
                    emit(Result.Error(Error.Network.SERVER_ERROR))
                }
            } catch (e: HttpException) {
                emit(Result.Error(Error.Network.NO_INTERNET))
            } catch (e: IOException) {
                emit(Result.Error(Error.Network.UNKNOWN))
            } catch (e: Exception) {
                emit(Result.Error(Error.Network.UNKNOWN))
            }
        }
}*/
