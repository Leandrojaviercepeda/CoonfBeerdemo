package com.example.coonfbeerdemo.network

interface Callback <T> {
    fun onSucces(result: T?)
    fun onFail(exception: Exception)

}