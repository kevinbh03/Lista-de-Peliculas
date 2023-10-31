package com.example.proyectapp.ui.listmovie

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import com.example.proyectapp.domain.MovieViewModel
import com.example.proyectapp.ui.listmovie.composable.ColumnListMovie
import com.example.proyectapp.ui.listmovie.composable.ColumnListMovieApp
import com.example.proyectapp.ui.theme.ProyectappTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel = ViewModelProvider(this).get(MovieViewModel::class.java)
            ProyectappTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ColumnListMovieApp(viewModel)
                }
            }
        }
    }
}

