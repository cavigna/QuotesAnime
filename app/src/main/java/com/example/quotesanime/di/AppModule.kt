package com.example.quotesanime.di

import com.example.quotesanime.network.QuotesAnimeApi
import com.example.quotesanime.repository.QuoteRepository
import com.example.quotesanime.utils.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideQuoteRepository(api: QuotesAnimeApi) = QuoteRepository(api)


    @Singleton
    @Provides
    fun provideQuoteAnimeApi() : QuotesAnimeApi{
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(QuotesAnimeApi::class.java)
    }



}