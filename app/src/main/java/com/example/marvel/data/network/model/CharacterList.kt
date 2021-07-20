package com.example.marvel.data.network.model

import com.google.gson.annotations.SerializedName

class CharacterList {

    @SerializedName("code")
    var code: Int? = 0
    @SerializedName("status")
    var status: String? = ""
    @SerializedName("data")
    var data: Data = Data()
}

class Data {
    @SerializedName("results")
    var results: List<Results> = ArrayList()
}

class Results {
    @SerializedName("name")
    var name: String? = ""
    @SerializedName("thumbnail")
    var thumbnail : Thumbnail = Thumbnail()
}

class Thumbnail {
    @SerializedName("path")
    var path: String? = ""
    @SerializedName("extension")
    var extension: String? = ""
}