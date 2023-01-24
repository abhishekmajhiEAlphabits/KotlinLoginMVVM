package com.example.kotlinloginmvvm.network

import com.example.kotlinloginmvvm.model.User
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface BackendApi {

    @FormUrlEncoded
    @POST("/api/login")
    fun LOGIN(
        @Field("email") email: String,
        @Field("password") password: String
    )
            : Call<LoginResponse>
}