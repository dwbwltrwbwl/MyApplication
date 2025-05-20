package com.example.myapplication
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object ApiClient {
    private const val BAS_URL = "http://10.0.2.2:7055"

    val instance: ApiService by lazy {
        Retrofit.Builder().baseUrl(BAS_URL).addConverterFactory(GsonConverterFactory.create()).build().create(ApiService::class.java)
    }
}