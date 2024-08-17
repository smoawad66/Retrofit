package com.example.retrofit.network

import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitConnection {

    private const val BASE_URL = "https://dummyjson.com/"
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(Gson()))
        .build()

    fun getService() : ApiService = retrofit.create(ApiService::class.java)
}