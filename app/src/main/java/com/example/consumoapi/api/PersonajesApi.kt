package com.example.consumoapi.api

import com.example.consumoapi.model.ListaPersonajes
import retrofit2.http.GET

interface PersonajesApi {

    @GET("character")
    suspend fun getPersonajes(): ListaPersonajes

}