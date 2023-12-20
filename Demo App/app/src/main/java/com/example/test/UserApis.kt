package com.example.test

import retrofit2.Call
import retrofit2.http.GET

interface UserApis {
    @GET("/products")
    fun  getProducts() : Call<ArrayList<Products>>
}