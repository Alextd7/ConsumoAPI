package com.example.consumoapi.di

import com.example.consumoapi.api.PersonajesApi
import com.example.consumoapi.utils.Constans.BASE_URL

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApi(): PersonajesApi {

        return Retrofit.Builder().
        baseUrl(BASE_URL).
                addConverterFactory(GsonConverterFactory.create()).build().create(PersonajesApi::class.java)
    }

}