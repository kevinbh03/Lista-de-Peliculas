package com.example.proyectapp.data

import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

class MovieViewModel : ViewModel() {
    private val apiService = Retrofit.Builder()
        .baseUrl("https://run.mocky.io/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApiService::class.java)

    val movies: MutableState<List<MovieItem>> = mutableStateOf(emptyList())

    init {
        viewModelScope.launch {
            movies.value = apiService.getMovies()
        }
    }
}
    }
}


