package com.example.marvel.data.network.model

import com.google.gson.annotations.SerializedName

data class HeroesList(
    @SerializedName("id")
    var id : Int? = 0,
    @SerializedName("localized_name")
    var name: String? = "",
    @SerializedName("img")
    var image: String? = "")

