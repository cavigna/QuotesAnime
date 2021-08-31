package com.example.quotesanime.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quotesanime.models.AnimeQuote
import com.example.quotesanime.repository.QuoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuoteViewModel @Inject constructor( private val repository: QuoteRepository):ViewModel() {
    var randomQuote :MutableState<AnimeQuote> = mutableStateOf(AnimeQuote())

    init{
        getRandomQuote()
    }


    fun getRandomQuote(){
        viewModelScope.launch(IO) {
            randomQuote.value = repository.randomQuote()
        }
    }
}