package com.ericho.restaurant_queue

import androidx.lifecycle.ViewModel
import com.ericho.composefeatureproj.api.RestaurantRepo
import com.ericho.composefeatureproj.di.Injection
import com.ericho.composefeatureproj.model.SeatQueue

class PullViewModel constructor() : ViewModel() {


    val repo: RestaurantRepo = Injection.provideRestaurantRepo()
    val items: List<SeatQueue> = repo.getRestaurantList()

    fun getTicket(numberOfPeople: String) {

    }
}