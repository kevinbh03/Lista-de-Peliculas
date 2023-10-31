package com.example.proyectapp.data

import com.example.proyectapp.model.Results

class ResultsRepository(private val resultsDataSource: ResultsDataSource) {
    suspend operator fun invoke(callback: OperationsCallback<Results>) {
        resultsDataSource.results(callback)
    }
}