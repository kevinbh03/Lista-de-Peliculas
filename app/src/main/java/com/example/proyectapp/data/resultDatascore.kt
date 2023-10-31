package com.example.proyectapp.data

import com.example.proyectapp.model.Results

interface ResultsDataSource {
    // suspende el parametro del resultado ¿preguntar?
    suspend fun results(callback: OperationsCallback<Results>)
    fun cancel()
}