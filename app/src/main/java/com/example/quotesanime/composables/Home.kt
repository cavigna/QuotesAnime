package com.example.quotesanime.composables

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.quotesanime.models.AnimeQuote
import com.example.quotesanime.ui.theme.DarkBlueSpaceCadete
import com.example.quotesanime.ui.theme.RedImperial
import com.example.quotesanime.ui.theme.LightBLueManatee
import com.example.quotesanime.ui.theme.QuotesAnimeTheme
import com.example.quotesanime.utils.Constants.irohQuote

@Preview
@Composable
fun PreviewHome() {
    QuotesAnimeTheme {
        RandomQuoteShow(irohQuote)
    }
}

@Composable
fun Home(

) {

}

@Composable
fun RandomQuoteShow(
    animeQuote: AnimeQuote,
    modifier: Modifier = Modifier
) {

    Surface(color = LightBLueManatee) {
    Box{
        Card(
            modifier.fillMaxSize().padding(20.dp),
            shape = RoundedCornerShape(15.dp),
            elevation = 10.dp, backgroundColor = DarkBlueSpaceCadete
        ) {
            Column(modifier.fillMaxSize().padding(10.dp)) {
                Text(
                    "\"${animeQuote.quote}\"",
                    color = Color.LightGray, style = conversorTypo(animeQuote.quote)
                )
                Row(modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
                ){

                Text(
                    "- ${animeQuote.personaje}",
                    color = Color.LightGray, style = MaterialTheme.typography.h6
                )}
                Box(){
                    Card(
                    backgroundColor = RedImperial,
                        shape = RoundedCornerShape(5.dp)
                        ) {
                        Text(
                            animeQuote.anime,
                            color = Color.LightGray, style = MaterialTheme.typography.subtitle1
                        )
                    }
                }
            }

        }
    }
    }

}
@Composable
fun conversorTypo(frase:String): TextStyle {
    return when(frase.length){
        in 1..75 ->MaterialTheme.typography.h1
        in 76..100 ->MaterialTheme.typography.h2
        in 101..125 ->MaterialTheme.typography.h3
        in 126..150 ->MaterialTheme.typography.h4



        else -> MaterialTheme.typography.h5
    }

}