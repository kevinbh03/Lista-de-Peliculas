package com.example.proyectapp.data

interface OperationsCallback<T> {

    fun onSuccess(data: T?)

    fun onError(error: String?)
}