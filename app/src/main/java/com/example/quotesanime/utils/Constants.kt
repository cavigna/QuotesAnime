package com.example.quotesanime.utils

import com.example.quotesanime.models.AnimeQuote

object Constants {
    val BASE_URL = "https://animechan.vercel.app/api/"

    val listQuotesPrueba by lazy { listOf(irohQuote,
    aangQuote, pinadoQuote, irohQuote2,
        zukoQuote, irohQuote3, turtleQuote, zukoQuote2, irohQuote4
        ) }

    val irohQuote = AnimeQuote(
         "Avatar: The Last Airbender",
        "Iroh",
        "You must look within yourself to save yourself from your other self. Only then will your true self reveal itself."
    )

    val aangQuote = AnimeQuote(
        "Avatar: The Last Airbender",
        "Aang",
        "If I try, I fail. If i don't try i'm never going to get it."
    )

    val pinadoQuote = AnimeQuote(
        "Avatar: The Last Airbender",
        "Aang",
        "The way of the sword doesn't belong to any one nation. Knowledge of the arts belongs to us all."
    )
    val irohQuote2 = AnimeQuote(
        "Avatar: The Last Airbender",
        "Iroh",
        "Life happens wherever you are, whether you make it or not."
    )

    val zukoQuote = AnimeQuote(
        "Avatar: The Last Airbender",
        "Zuko",
        "Never forget who you are, for surely the world won't."
    )

    val irohQuote3 = AnimeQuote(
        "Avatar: The Last Airbender",
        "Iroh",
        "It is important to draw wisdom from different places. If you take it from only one place, it becomes rigid and stale."
    )

    val turtleQuote = AnimeQuote(
        "Avatar: The Last Airbender",
        "Lion Turtle",
        "The true mind can weather all lies and illusions without being lost. The true heart can touch the poison of hatred without being harmed. From beginningless time, darkness thrives in the void, but always yields to purifying light."
    )

    val zukoQuote2 = AnimeQuote(
        "Avatar: The Last Airbender",
        "Zuko",
        "In the darkness, hope is something you give yourself."
    )

    val irohQuote4 = AnimeQuote(
        "Avatar: The Last Airbender",
        "Iroh",
        "You may not always see the light at the end of the tunnel, but if you keep moving, you will come to a better place."
    )


}

