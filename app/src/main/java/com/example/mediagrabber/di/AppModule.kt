package com.example.mediagrabber.di


import com.example.mediagrabber.BuildConfig
import com.example.mediagrabber.data.source.remote.api.MediaGrabberApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
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


}