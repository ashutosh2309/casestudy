package com.example.myapplication


import retrofit2.Call
import retrofit2.http.GET

interface MainService {
    @GET("api/v1/json/1/all_sports.php")
    fun getAllLeagues():Call<MainModelList>
}