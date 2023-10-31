package com.example.proyectapp.model



data class Results(
    var results: List<Result>
)

data class Result(
    var name: String,
    var type: String
)