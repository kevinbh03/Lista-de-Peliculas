package com.example.proyectapp.data

import com.google.gson.annotations.SerializedName

//respuesta del api
data class ResultsResponse(
    @SerializedName("results")
    var results: ArrayList<ResultResponse> = arrayListOf()
)

//datos de la respuesta del api
data class ResultResponse(
    @SerializedName("name")
    var name: String,
    @SerializedName("type")
    var type: String
)