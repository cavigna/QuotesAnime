package com.example.quotesanime.composables

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHost
import com.example.quotesanime.models.AnimeQuote
import com.example.quotesanime.ui.theme.*
import com.example.quotesanime.utils.Constants.irohQuote
import com.example.quotesanime.utils.Constants.listQuotesPrueba
import com.example.quotesanime.viewmodel.QuoteViewModel
import dagger.hilt.android.lifecycle.HiltViewModel

@Preview(showBackground = true)
@Composable
fun PreviewListadoFrases(

) {
    QuotesAnimeTheme {
        //TarjetaQuote(irohQuote)
        //ListadoFrases(listQuotesPrueba, "Avatar: The Last Airbender")
        ListadoFrases(listQuotesPrueba, "Avatar: The Last Airbender")
    }

}

@Composable
fun ListadoFrases(
    listadoFrase: List<AnimeQuote>,
    tituloONombre: String? = null,
    //viewModel: QuoteViewModel= hiltViewModel(),
    viewModel: QuoteViewModel? = null,
    modifier: Modifier = Modifier,
) {
    Surface(color = GreyLightSilverHand) {
        if (tituloONombre != null) {
            Column() {
                HeaderAnime(tituloONombre)
                LazyColumn(verticalArrangement = Arrangement.spacedBy(20.dp)) {
                    items(listadoFrase.size) {
                        val currentQuote = listadoFrase[it]
                        TarjetaQuote(currentQuote)
                    }
                }
            }
        } else {
            LazyColumn(verticalArrangement = Arrangement.spacedBy(20.dp)) {
                items(listadoFrase.size) {
                    val currentQuote = listadoFrase[it]
                    TarjetaQuote(currentQuote)
                }
            }
        }

    }

}

@Composable
fun TarjetaQuote(
    animeQuote: AnimeQuote,
    viewModel: QuoteViewModel? = null,
    modifier: Modifier = Modifier
) {
    Surface(
        color = GreyLightSilverHand
    ) {
        Card(
            shape = RoundedCornerShape(15.dp),
            elevation = 20.dp, backgroundColor = DarkBlueRaisinBlack4,
            modifier = modifier.padding(15.dp)
        ) {
            Column(
                modifier.fillMaxSize()
                    .padding(10.dp),
                verticalArrangement = Arrangement.Center.also { Arrangement.spacedBy(10.dp) },
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                Text(
                    "\" ${animeQuote.quote} \"",
                    color = Color.LightGray, style = conversorTypo(animeQuote.quote)
                )
                Row(
                    modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {

                    Text(
                        "- ${animeQuote.personaje}",
                        color = Color.LightGray, style = MaterialTheme.typography.h4
                    )
                }
                BotonAnimeTitle(animeQuote, viewModel)
                FilaAnimeTitle(animeQuote)
            }

        }
    }

}

@Composable
fun FilaAnimeTitle(
    animeQuote: AnimeQuote,
    modifier: Modifier = Modifier

) {
    Row(
        modifier.fillMaxWidth().padding(vertical = 10.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        Card(
            modifier = modifier.padding(5.dp),
            backgroundColor = RedCrisom,
            shape = RoundedCornerShape(5.dp)
        ) {
            Text(
                animeQuote.anime,
                color = GreyAliceBLue, style = MaterialTheme.typography.body1,
                modifier = modifier.padding(5.dp)
            )
        }
    }
}

@Composable
fun HeaderAnime(
    tituloONombreAnime: String,
    modifier: Modifier = Modifier

) {
    Row(
        modifier.fillMaxWidth().padding(vertical = 10.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        Card(
            modifier = modifier.padding(5.dp),
            backgroundColor = RedCrisom,
            shape = RoundedCornerShape(5.dp)
        ) {
            Text(
                tituloONombreAnime,
                color = GreyAliceBLue, style = MaterialTheme.typography.h2,
                modifier = modifier.padding(5.dp),
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun BotonAnimeTitle(
    animeQuote: AnimeQuote,
    viewModel: QuoteViewModel? = null,
    navController: NavController? = null,
    modifier: Modifier = Modifier

) {
    Row(
        modifier.fillMaxWidth().padding(vertical = 10.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        Button(
            modifier = modifier.padding(5.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = RedCrisom),
            shape = RoundedCornerShape(5.dp),
            onClick = {
                viewModel!!.getlistQuotesByTitle(animeQuote.anime)
                val listAnimeQuote = viewModel.listRandomQuote.component1()
                navController!!.navigate("list_by_name")
//                ListadoFrases(listAnimeQuote, animeQuote.anime, viewModel)
            }
        ) {
            Text(
                animeQuote.anime,
                color = GreyAliceBLue, style = MaterialTheme.typography.body1,
                modifier = modifier.padding(5.dp),
                textAlign = TextAlign.Center
            )
        }
    }
}