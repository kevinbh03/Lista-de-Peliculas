package com.example.proyectapp.ui.listmovie.composable

import android.graphics.Movie
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.proyectapp.R
import com.example.proyectapp.domain.MovieViewModel
import com.example.proyectapp.ui.theme.Purple200


@Composable
fun ColumnListMovieApp(movieViewModel: MovieViewModel) {
    Column {
        HeaderTitle()
        ColumnListMovie(movieViewModel.Movies)
        Spacer(modifier = Modifier.weight(1f))
        FootList()
    }
}

@Composable
fun ColumnListMovie(movies: List<Movie>) {
    Column {
        for (movie in movies) {
            ListMovie(movie)
        }
    }
}



@Composable
fun HeaderTitle(){
    Box(modifier = Modifier
        .fillMaxWidth()
        .background(color = Purple200)) {
        Text(text = "Movies")
    }
}


@Composable
fun ListMovie(movie: Movie) {
    Row() {
        Text(text = "movie.name")
        Text(text = "movie.type")
    }
}


@Composable
fun FootList() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_home_24dp),
                contentDescription = "Home"
            )
            Text(text = "Home")
        }

        Column(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_movie_24dp),
                contentDescription = "Movie"
            )
            Text(text = "Movie")
        }

        Column(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_serie_24dp),
                contentDescription = "Series"
            )
            Text(text = "Serie")
        }
    }


    @Composable
    fun ContactItem(movie: Movie) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Row() {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(text = "Tipo: ${movie.Type}")
                    Text(text = "Nombre: ${movie.Name}")
                }

            }
        }
    }

}



