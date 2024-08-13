package com.example.mediagrabber.di


import android.content.Context
import com.example.mediagrabber.BuildConfig
import com.example.mediagrabber.core.Downloader
import com.example.mediagrabber.data.repository.MediaGrabberRepositoryImpl
import com.example.mediagrabber.data.source.remote.api.MediaGrabberApiService
import com.example.mediagrabber.domain.repositoty.MediaGrabberRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideMediaGrabberApiService(): MediaGrabberApiService {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(MediaGrabberApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideDownloader(@ApplicationContext app: Context): Downloader {
        return Downloader(app)
    }


}

@Module
@InstallIn(SingletonComponent::class)
abstract class Repository {
    @Binds
    @Singleton
    abstract fun bindMediaGrabberRepository(mediaGrabberRepositoryImpl: MediaGrabberRepositoryImpl): MediaGrabberRepository

}