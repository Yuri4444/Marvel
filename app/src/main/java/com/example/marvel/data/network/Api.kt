package com.example.marvel.data.network

import com.example.marvel.data.network.model.HeroesList
import retrofit2.http.GET

interface Api {

    @GET("heroStats")
    suspend fun getHeroes() : List<HeroesList>
}