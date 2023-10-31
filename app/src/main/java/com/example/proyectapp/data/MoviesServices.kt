package com.example.proyectapp.data

import com.example.proyectapp.model.Results
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ResultsRemoteDataSource(apiClient: ApiClient) : ResultsDataSource {

    //almacena el  Resultresponse
    private var call: Call<ResultsResponse>? = null
    //crea una instancia de service ¿preguntar?
    private val service = apiClient.build()

    //ontiene resultados de almacena elresultado
    override suspend fun results(callback: OperationsCallback<Results>) {

        call = service.results()
        call?.enqueue(object : Callback<ResultsResponse> {
            //si falla
            override fun onFailure(call: Call<ResultsResponse>, t: Throwable) {
                callback.onError(t.message)
            }

            //si existe
            override fun onResponse(
                call: Call<ResultsResponse>,
                response: Response<ResultsResponse>
            ) {
                response.body()?.let {
                    //corrutina que crea una lista para llamar todos los datos
                    if (response.isSuccessful) {
                        val results =
                            Results(
                                it.results.map {
                                    Result(it.name, it.type)
                                } as ArrayList<Result>
                            )
                        callback.onSuccess(results)
                    }
                }
            }
        })
    }

    //cancela la operacion
    override fun cancel() {
        call?.let {
            it.cancel()
        }
    }
}