package com.example.marvel.data.network

import com.example.marvel.data.network.model.CharacterList
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET("/v1/public/characters")
    suspend fun getCharacter(
        @Query("apikey") apiKey: String? = "8d29d02df25c8ca489092117aaee2454",
        @Query("hash") hash: String? = "af1da214cbea559d1ddb61f64ff39129",
        @Query("ts") ts: Int? = 1
    ): CharacterList

    @GET("/v1/public/characters")
    suspend fun searchCharacter(
        @Query("apikey") apiKey: String? = "8d29d02df25c8ca489092117aaee2454",
        @Query("hash") hash: String? = "af1da214cbea559d1ddb61f64ff39129",
        @Query("ts") ts: Int? = 1,
        @Query("name") name: String
    )  : CharacterList

    @GET("/v1/public/comics")
    suspend fun getComics(
        @Query("apikey") apiKey: String? = "8d29d02df25c8ca489092117aaee2454",
        @Query("hash") hash: String? = "af1da214cbea559d1ddb61f64ff39129",
        @Query("ts") ts: Int? = 1
    ): CharacterList

}