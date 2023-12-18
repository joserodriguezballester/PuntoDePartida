package com.example.esqueleto.di

import com.example.esqueleto.Utils.Constants
import com.example.esqueleto.api.Repository
import com.example.esqueleto.api.RetrofitApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitApiFactory {

    fun provideRetrofitApi(): RetrofitApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constants.BASE_URL)
            .build()
            .create(RetrofitApi::class.java)
    }
    fun provideRepository():Repository{
      val apiService= provideRetrofitApi()
        val repository=Repository(apiService)
        return repository
    }
}