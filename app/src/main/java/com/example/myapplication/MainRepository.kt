package com.example.myapplication

import io.reactivex.Single
import io.reactivex.SingleEmitter
import io.reactivex.SingleOnSubscribe
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainRepository {


    fun getServerData(): Single<MainModelList> {
        return Single.create(object : SingleOnSubscribe<MainModelList> {
            override fun subscribe(e: SingleEmitter<MainModelList>) {
                Retrofit.Builder().baseUrl(MainConstants.BASE_URL).client(OkHttpClient())
                    .addConverterFactory(GsonConverterFactory.create()).build()
                    .create(MainService::class.java)
                    .getAllLeagues().enqueue(object : Callback<MainModelList> {
                        override fun onFailure(call: Call<MainModelList>, t: Throwable) {
                            e.onError(t)
                        }

                        override fun onResponse(
                            call: Call<MainModelList>,
                            response: Response<MainModelList>
                        ) {
                            e.onSuccess(response.body() ?: MainModelList(ArrayList()))

                        }
                    })
            }
        })
    }
}