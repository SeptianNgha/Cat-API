package com.android.mycat.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface CatApi {

    // https://thecatapi.com/v1/breeds?api_key=106e6c0b-8e3f-4fb9-8b37-9b27f8b58547

    @Headers("x-api-key: 106e6c0b-8e3f-4fb9-8b37-9b27f8b58547")
    @GET("v1/breeds")
    fun getCat(
//        @Query("attach_breed") attach_breed: Int,
//        @Query("page") page: Int,
//        @Query("limit") limit: Int
    ): Call<ArrayList<CatResponse>>
}