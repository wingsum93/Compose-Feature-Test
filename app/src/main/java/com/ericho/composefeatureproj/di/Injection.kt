package com.ericho.composefeatureproj.di

import com.ericho.composefeatureproj.api.RestaurantRepo
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Injection {
    fun provideRestaurantRepo(): RestaurantRepo {
        return RestaurantRepo(provideRetrofit())
    }

    fun provideRetrofit(): Retrofit {
        val gson = GsonBuilder()
            .setDateFormat("YYYY-MM-dd HH:mm:ss")
            .create()
        return Retrofit.Builder()
            .baseUrl("https://restaurants-queue.herokuapp.com")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(provideOkhttpClient())
            .build()
    }

    private fun provideOkhttpClient(): OkHttpClient {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient.Builder()
            .addNetworkInterceptor(logging)
            .build()
    }
}