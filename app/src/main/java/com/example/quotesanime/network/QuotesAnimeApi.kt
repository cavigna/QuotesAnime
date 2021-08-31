package com.example.quotesanime.network

import com.example.quotesanime.models.AnimeQuote
import retrofit2.http.GET

interface QuotesAnimeApi {

    @GET("random")
    suspend fun randomQuote(): AnimeQuote
}