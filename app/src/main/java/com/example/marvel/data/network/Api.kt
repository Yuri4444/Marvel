package com.example.marvel.data.network

import com.example.marvel.data.network.model.HeroesList
import retrofit2.http.GET

interface Api {

//    @GET("heroStats")
    @GET("c9a46124-a135-49b3-a9fa-d7ae4a456de1")
    suspend fun getHeroes() : List<HeroesList>
}