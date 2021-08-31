package com.example.quotesanime.repository

import com.example.quotesanime.models.AnimeQuote
import com.example.quotesanime.network.QuotesAnimeApi
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class QuoteRepository @Inject constructor(
    private val api : QuotesAnimeApi
){
    suspend fun randomQuote():AnimeQuote{
        return api.randomQuote()
    }
}