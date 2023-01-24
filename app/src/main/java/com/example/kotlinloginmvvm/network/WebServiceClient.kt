package com.example.kotlinloginmvvm.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object WebServiceClient {
    private var retrofit: Retrofit? = null
    private const val API_BASE_URL = "https://reqres.in/"

    fun client(): Retrofit {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit!!
    }
}