package com.ericho.composefeatureproj.api

import com.ericho.composefeatureproj.R
import com.ericho.composefeatureproj.model.Queue
import com.ericho.composefeatureproj.model.SeatQueue
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.create
import java.io.IOException

class RestaurantRepo(retrofit: Retrofit) {

    private val api: RestaurantAPI = retrofit.create()

    suspend fun getOneTicket(number: Int = 1): Result<Queue> {
        return withContext(Dispatchers.IO) {
            try {
                val res = api.getTicket(number)
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
        val res = api.checkSingleQueue(code)
        return withContext(Dispatchers.IO) {
            try {
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
        val res = api.checkQueueOfType(number)
        return withContext(Dispatchers.IO) {
            try {
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

    fun getRestaurantList(): List<SeatQueue> {
        val first = SeatQueue("One Person", R.drawable.cook_11as)
        val second = SeatQueue("Two Person", R.drawable.cook_11as)
        return listOf(first, second)
    }
}