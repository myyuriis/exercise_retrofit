package com.example.exercise_retrofit

import com.example.exercise_retrofit.artist.ArtistAPI
import com.example.exercise_retrofit.config.RetrofitBuilder
import dagger.Module
import dagger.Provides
import retrofit2.*

@Module
class NetworkModule {

    @Provides
    fun providerArtistAPI(): ArtistAPI {
        return RetrofitBuilder.createRetrofit().create(ArtistAPI::class.java)
    }
}