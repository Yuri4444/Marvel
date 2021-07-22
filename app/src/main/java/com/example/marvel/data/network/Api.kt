package com.example.marvel.data.network

import com.example.marvel.data.network.model.CharacterList
import com.example.marvel.utils.API_KEY
import com.example.marvel.utils.HASH
import com.example.marvel.utils.TS
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET("/v1/public/characters")
    suspend fun getCharacter(
        @Query("apikey") apiKey: String? = API_KEY,
        @Query("hash") hash: String? = HASH,
        @Query("ts") ts: Int? = TS
    ): CharacterList

    @GET("/v1/public/characters")
    suspend fun searchCharacter(
        @Query("apikey") apiKey: String? = API_KEY,
        @Query("hash") hash: String? = HASH,
        @Query("ts") ts: Int? = TS,
        @Query("name") name: String
    )  : CharacterList

    @GET("/v1/public/comics")
    suspend fun getComics(
        @Query("apikey") apiKey: String? = API_KEY,
        @Query("hash") hash: String? = HASH,
        @Query("ts") ts: Int? = TS
    ): CharacterList

}