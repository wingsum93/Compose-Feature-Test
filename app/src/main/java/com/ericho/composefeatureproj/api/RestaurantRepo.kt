package com.ericho.composefeatureproj.api

import com.ericho.composefeatureproj.model.Queue
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.io.IOException

class RestaurantRepo {
    private val client = OkHttpClient.Builder()
        .build()
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://restaurants-queue.herokuapp.com")
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    private val api: RestaurantAPI = retrofit.create()


    suspend fun getOneTicket(number: Int = 1): Result<Queue> {
        val call = api.getTicket(number)
        return withContext(Dispatchers.IO) {
            try {
                val res = call.execute()
                if (res.isSuccessful) {
                    val body = res.body()
                    if (body?.status == true && body.result != null) {
                        Result.success(body.result!!)
                    } else {
                        Result.failure(UnsupportedOperationException("data wrong"))
                    }
                } else {
                    Result.failure(UnsupportedOperationException("network call fail"))
                }
            } catch (e: IOException) {
                Result.failure(e)
            }
        }
    }

    suspend fun checkQueueStatus(code: String): Result<Boolean> {
        val call = api.checkSingleQueue(code)
        return withContext(Dispatchers.IO) {
            try {
                val res = call.execute()
                if (res.isSuccessful) {
                    val body = res.body()
                    if (body?.status == true && body.result != null) {
                        Result.success(body.result!!.hasTable)
                    } else {
                        Result.failure(UnsupportedOperationException("data wrong"))
                    }
                } else {
                    Result.failure(UnsupportedOperationException("network call fail"))
                }
            } catch (e: IOException) {
                Result.failure(e)
            }
        }
    }

    suspend fun checkQueueOfType(number: Int): Result<Queue> {
        val call = api.checkQueueOfType(number)
        return withContext(Dispatchers.IO) {
            try {
                val res = call.execute()
                if (res.isSuccessful) {
                    val body = res.body()
                    if (body?.status == true && body.result != null) {
                        Result.success(body.result!!)
                    } else {
                        Result.failure(UnsupportedOperationException("data wrong"))
                    }
                } else {
                    Result.failure(UnsupportedOperationException("network call fail"))
                }
            } catch (e: IOException) {
                Result.failure(e)
            }
        }
    }
}