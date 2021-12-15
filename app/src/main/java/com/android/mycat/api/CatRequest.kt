package com.android.mycat.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object CatRequest {

    private const val BASE_URL = "https://api.thecatapi.com/"
    val instance: CatApi by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(CatApi::class.java)
    }

}