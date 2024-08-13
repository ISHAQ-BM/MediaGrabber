package com.example.mediagrabber.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mediagrabber.core.Downloader
import com.example.mediagrabber.core.Result
import com.example.mediagrabber.domain.repositoty.MediaGrabberRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MediaGrabberViewModel @Inject constructor(
    private val mediaGrabberRepository: MediaGrabberRepository,
    private val downloader: Downloader
) : ViewModel() {

    private val _uiState = MutableStateFlow(MediaGrabberUiState())
    val uiState: StateFlow<MediaGrabberUiState> = _uiState.asStateFlow()


    fun getDownloadableUrl(url: String) {
        viewModelScope.launch {
            _uiState.update {
                it.copy(
                    isLoading = true
                )
            }
            mediaGrabberRepository.getDownloadableUrls(url).collect { result ->
                when (result) {
                    is Result.Error -> _uiState.update {
                        it.copy(
                            isLoading = false
                        )
                    }

                    is Result.Success -> _uiState.update {
                        val links = mutableMapOf<String, String>()
                        result.data.links.map {
                            links.put(it.quality, it.link)
                        }
                        it.copy(
                            links = links,
                            imageUrl = result.data.picture,
                            title = result.data.title,
                            isLoading = false,
                        )
                    }
                }

            }


            /*when(extractSocialMediaPlatform(url)){
               "Facebook" ->{
                   mediaGrabberRepository.getFacebookDownloadableUrl(url).collect{result ->
                       when(result){
                           is Result.Error -> {
                               Log.d("error","error")}
                           is Result.Success -> {
                               _uiState.update {
                                   it.copy(
                                       downloadableUrl = formatDownloadableUrl(result.data.videoQualities[0].url)
                                   )
                               }
                               download()
                           }
                       }
                   }
               }
               "Instagram" ->{
                   mediaGrabberRepository.getInstagramReelDownloadableUrl("reel",url).collect{result ->
                       when(result){
                           is Result.Error -> {
                               Log.d("error","error")}
                           is Result.Success -> {
                               _uiState.update {
                                   it.copy(
                                       downloadableUrl = formatDownloadableUrl(result.data.url)
                                   )
                               }
                               download()
                           }
                       }
                   }
               }
               "TikTok" ->{
                   mediaGrabberRepository.getTikTokDownloadableUrl(url).collect{result ->
                       when(result){
                           is Result.Error -> {
                               Log.d("error","error")}
                           is Result.Success -> {
                               _uiState.update {
                                   it.copy(
                                       downloadableUrl = formatDownloadableUrl(result.data.downloadUrls[0].url)
                                   )
                               }
                               download()
                           }
                       }
                   }
               }
               "YouTube" ->{
                   mediaGrabberRepository.getYoutubeDownloadableUrl(url).collect{result ->
                       when(result){
                           is Result.Error -> {
                               Log.d("error","error")}
                           is Result.Success -> {
                               _uiState.update {
                                   it.copy(
                                       downloadableUrl = formatDownloadableUrl(result.data.youtubeFormats[0].url)
                                   )
                               }
                               download()
                           }
                       }
                   }
               }
               "SoundCloud" ->{
                   mediaGrabberRepository.getSoundCloudDownloadableUrl(url).collect{result ->
                       when(result){
                           is Result.Error -> {
                               Log.d("error","error")}
                           is Result.Success -> {
                               _uiState.update {
                                   it.copy(
                                       downloadableUrl = formatDownloadableUrl(result.data.downloadUrl)
                                   )
                               }
                               download()
                           }
                       }
                   }
               }
               "Pinterest" ->{
                   mediaGrabberRepository.getPinterestDownloadableUrl(url).collect{result ->
                       when(result){
                           is Result.Error -> {
                               Log.d("error","error")}
                           is Result.Success -> {
                               _uiState.update {
                                   it.copy(
                                       downloadableUrl = formatDownloadableUrl(result.data.downloadLinks[0].url)
                                   )
                               }
                               download()
                           }
                       }
                   }
               }
               "LinkedIn" ->{
                   mediaGrabberRepository.getLinkedInDownloadableUrl(url).collect{result ->
                       when(result){
                           is Result.Error -> {
                               Log.d("error","error")}
                           is Result.Success -> {
                               _uiState.update {
                                   it.copy(
                                       downloadableUrl = formatDownloadableUrl(result.data.formats[0].url)
                                   )
                               }
                               download()
                           }
                       }
                   }
               }
               else -> {}
           }*/


        }
    }

    /* private fun extractSocialMediaPlatform(url: String): String {
         return when {
             url.contains("tiktok", ignoreCase = true) -> "TikTok"
             url.contains("soundcloud", ignoreCase = true) -> "SoundCloud"
             url.contains("instagram", ignoreCase = true) -> "Instagram"
             url.contains("you", ignoreCase = true) -> "YouTube"
             url.contains("facebook", ignoreCase = true) -> "Facebook"
             url.contains("pinterest", ignoreCase = true) -> "Pinterest"
             url.contains("linkedin", ignoreCase = true) -> "LinkedIn"
             else -> "Unknown"
         }
     }

     private fun formatDownloadableUrl(url:String):String{

         return StringBuilder(url).deleteCharAt(7).deleteCharAt(9).toString()
     }
 */
    fun download(url: String) {
        downloader.downloadFile(url)
    }


}