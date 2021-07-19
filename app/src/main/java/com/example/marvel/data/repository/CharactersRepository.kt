package com.example.marvel.data.repository

import com.example.marvel.data.network.Api
import javax.inject.Inject

class CharactersRepository @Inject constructor(private val api: Api) {

    suspend fun getHeroes() = api.getHeroes()


}