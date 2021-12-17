package com.ericho.composefeatureproj.di

import com.ericho.composefeatureproj.api.RestaurantRepo
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Injection {
    fun provideRestaurantRepo(): RestaurantRepo {
        return RestaurantRepo(provideRetrofit())
    }

    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://restaurants-queue.herokuapp.com")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .client(provideOkhttpClient())
            .build()
    }

    fun provideOkhttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .build()
    }
}