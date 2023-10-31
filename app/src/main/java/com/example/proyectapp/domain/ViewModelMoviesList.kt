package com.example.proyectapp.domain

import androidx.lifecycle.ViewModel
import com.example.proyectapp.data.Movie


class MovieViewModel : ViewModel() {
    val Movies: List<Movie> = listOf(
        Movie("Parasite", "MOVIE"),
        Movie("Game of Thrones", "SERIES"),
        Movie("Joker", "MOVIE"),
        Movie("Captain Marvel", "MOVIE"),
        Movie("Friends", "SERIES"),
        Movie("The Big Bang Theory", "SERIES"),
        Movie("Bohemian Rhapsody", "MOVIE"),
        Movie("How I Met Your Mother", "SERIES"),
        Movie("The Mandalorian", "SERIES")
    )
}