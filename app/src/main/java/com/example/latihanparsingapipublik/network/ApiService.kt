package com.example.latihanparsingapipublik.network

import com.example.latihanparsingapipublik.model.ResponseUser
import retrofit2.Call
import retrofit2.http.*

interface ApiService {

    //Ambil list data keseluruhan
    @GET("api/users")
    fun getListUsers(@Query("page") page : String): Call<ResponseUser>

}