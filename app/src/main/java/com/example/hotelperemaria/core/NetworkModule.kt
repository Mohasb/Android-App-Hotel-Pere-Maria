package com.example.hotelperemaria.core

import com.example.hotelperemaria.ui.home.data.network.HomeClient
import com.example.hotelperemaria.ui.roomDetails.data.network.DetailsClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    //BaseURL Api
    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder().baseUrl("http://10.0.2.2:3000")
            .addConverterFactory(GsonConverterFactory.create()).build()

    // Retrofit to homeScreen Client
    @Singleton
    @Provides
    fun provideHomeClient(retrofit: Retrofit): HomeClient =
        retrofit.create(HomeClient::class.java)

    @Singleton
    @Provides
    fun provideDetailsRoom(retrofit: Retrofit):  DetailsClient =
        retrofit.create(DetailsClient::class.java)
}