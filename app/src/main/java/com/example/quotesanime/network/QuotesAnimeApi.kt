package com.example.quotesanime.network

import com.example.quotesanime.models.AnimeQuote
import retrofit2.http.GET
import retrofit2.http.Query

interface QuotesAnimeApi {

    @GET("random")
    suspend fun randomQuote(): AnimeQuote

    @GET("quotes")
    suspend fun listRandomQuotes(): List<AnimeQuote>

    @GET("quotes/anime") // 'https://animechan.vercel.app/api/quotes/anime?title=naruto'
    suspend fun listQuotesByTitle(@Query("title") title: String): List<AnimeQuote>

    @GET("quotes/character")
    suspend fun quotesByCharacter(@Query("name") name: String): List<AnimeQuote>
}