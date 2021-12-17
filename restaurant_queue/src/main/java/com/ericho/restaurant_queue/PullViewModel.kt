package com.ericho.restaurant_queue

import androidx.lifecycle.ViewModel
import com.ericho.composefeatureproj.api.RestaurantRepo
import com.ericho.composefeatureproj.di.Injection
import com.ericho.composefeatureproj.model.SeatQueue
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class PullViewModel constructor() : ViewModel() {


    val repo: RestaurantRepo = Injection.provideRestaurantRepo()
    val items: List<SeatQueue> = repo.getRestaurantList()

    val flow: Flow<String> = flow {
        emit("a")
    }

    fun getTicket(numberOfPeople: String) {

    }
}