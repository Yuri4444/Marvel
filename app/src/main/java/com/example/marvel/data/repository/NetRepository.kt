package com.example.marvel.data.repository

import com.example.marvel.data.network.Api
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.concurrent.timerTask

@Singleton
class NetRepository (private val api: Api) {

    suspend fun getCharacter(limit: Int, offset: Int) = api.getCharacter(limit = limit, offset = offset).data.results

    suspend fun searchCharacter(name: String) = api.searchCharacter(name = name).data.results

    suspend fun getComics() = api.getComics().data.results

}