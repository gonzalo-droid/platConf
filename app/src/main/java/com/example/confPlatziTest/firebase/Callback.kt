package com.example.confPlatziTest.firebase

import java.lang.Exception

interface Callback<T> {
    fun onSuccess(resul: T?)

    fun onFailed(exception: Exception)
}