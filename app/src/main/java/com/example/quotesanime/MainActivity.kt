package com.example.quotesanime

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.quotesanime.composables.RandomQuoteShow
import com.example.quotesanime.models.AnimeQuote
import com.example.quotesanime.ui.theme.QuotesAnimeTheme
import com.example.quotesanime.viewmodel.QuoteViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: QuoteViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuotesAnimeTheme {

                val randomQuote = viewModel.randomQuote
                val animeQuote = randomQuote.component1()
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                RandomQuoteShow(animeQuote)
                //Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun ShowRandomQuote(animeQuote: AnimeQuote){
    Text(animeQuote.quote)
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    QuotesAnimeTheme {
        Greeting("Android")
    }
}