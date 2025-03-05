package com.example.consumoapi.repository

import com.example.consumoapi.api.PersonajesApi
import com.example.consumoapi.model.ListaPersonajes
import javax.inject.Inject

class PersonajesRepository @Inject constructor(
    private val personajesApi: PersonajesApi
){

suspend fun getPesonajes() : ListaPersonajes{
    return personajesApi.getPersonajes()
}

}