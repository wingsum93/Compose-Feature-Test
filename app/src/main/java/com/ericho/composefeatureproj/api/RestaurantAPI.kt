package com.ericho.composefeatureproj.api

import com.ericho.composefeatureproj.model.SingleTicketResponse
import com.ericho.composefeatureproj.model.TicketResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface RestaurantAPI {

    @GET("/ticketing/member/{member}")
    suspend fun getTicket(@Path("member") member: Int): Call<TicketResponse>

    @GET("/queue/{queue_code}")
    suspend fun checkSingleQueue(@Path("queue_code") queue_code: String): Call<SingleTicketResponse>

    @GET("/queue/updateState/member/{member}")
    suspend fun checkQueueOfType(@Path("member") member: Int): Call<TicketResponse>
}