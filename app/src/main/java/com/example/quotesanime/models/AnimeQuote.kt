package com.example.quotesanime.models


import com.google.gson.annotations.SerializedName

data class AnimeQuote(
    @SerializedName("anime")
    var anime: String = "",

    @SerializedName("character")
    var personaje: String = "",

    @SerializedName("quote")
    var quote: String = ""

)