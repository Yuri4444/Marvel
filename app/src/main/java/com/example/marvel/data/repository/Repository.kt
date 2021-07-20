package com.example.marvel.data.repository

import com.example.marvel.data.network.Api
import javax.inject.Inject
import kotlin.concurrent.timerTask

class Repository @Inject constructor(private val api: Api) {

    suspend fun getCharacter() = api.getCharacter().data.results

    suspend fun searchCharacter(name: String) = api.searchCharacter(name = name).data.results

    suspend fun getComics() = api.getComics().data.results

}