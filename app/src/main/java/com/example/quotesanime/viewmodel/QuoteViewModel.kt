package com.example.quotesanime.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quotesanime.models.AnimeQuote
import com.example.quotesanime.repository.QuoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuoteViewModel @Inject constructor( private val repository: QuoteRepository):ViewModel() {
    var randomQuote :MutableState<AnimeQuote> = mutableStateOf(AnimeQuote())
    var listRandomQuote : MutableState<List<AnimeQuote>> =  mutableStateOf(listOf())
    var listQuotesByTitle : MutableState<List<AnimeQuote>> =  mutableStateOf(listOf())
    var quotesByCharacter : MutableState<List<AnimeQuote>> =  mutableStateOf(listOf())

    private val _isRefreshing = MutableStateFlow(false)

    val isRefreshing: StateFlow<Boolean>
        get() = _isRefreshing.asStateFlow()

    init{
        getRandomQuote()
        getListRandomQuote()
    }


    fun getRandomQuote(){
        viewModelScope.launch(IO) {
            randomQuote.value = repository.randomQuote()
        }
    }

    fun getListRandomQuote(){
        viewModelScope.launch(IO) {
            listRandomQuote.value = repository.listRandomQuotes()
        }
    }

    fun getlistQuotesByTitle(title:String){
        viewModelScope.launch(IO) {
            listQuotesByTitle.value = repository.listQuotesByTitle(title)
        }
    }

    fun getquotesByCharacter(name:String){
        viewModelScope.launch(IO) {
            quotesByCharacter.value = repository.quotesByCharcacter(name)
        }
    }



}