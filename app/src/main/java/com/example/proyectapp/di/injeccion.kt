package com.example.proyectapp.di

import com.example.proyectapp.data.ApiClient
import com.example.proyectapp.data.ResultsDataSource
import com.example.proyectapp.data.ResultsRemoteDataSource
import com.example.proyectapp.data.ResultsRepository

class Injection {
    //variables que almacena instancias de fuentes
    private var resultsDataSource: ResultsDataSource? = null
    private var resultsRepository: ResultsRepository? = null

    private fun createResultsDataSource(): ResultsDataSource {
        val dataSource = ResultsRemoteDataSource(ApiClient)
        resultsDataSource = dataSource
        return dataSource
    }

    private fun createResultsRepository(): ResultsRepository {
        val repository = ResultsRepository(provideDataSource())
        resultsRepository = repository
        return repository
    }

    private fun provideDataSource() = resultsDataSource ?: createResultsDataSource()
    fun providerResultRepository() = resultsRepository ?: createResultsRepository()

    fun destroy() {
        resultsDataSource = null
        resultsRepository = null
    }
}