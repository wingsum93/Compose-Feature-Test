package com.ericho.restaurant_queue

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ericho.composefeatureproj.api.RestaurantRepo
import com.ericho.composefeatureproj.di.Injection
import com.ericho.composefeatureproj.model.Queue
import kotlinx.coroutines.launch

class PullViewModel(val repo: RestaurantRepo = Injection.provideRestaurantRepo()) : ViewModel() {

    var numberOfPeople by mutableStateOf(0)
        private set

    var ticketQueueCode by mutableStateOf<Queue?>(null)
        private set

    fun getTicket(people: String) {
        viewModelScope.launch {
            people.toIntOrNull()?.apply {
                numberOfPeople = this
                val result = repo.getOneTicket(this)
                if (result.isSuccess) {
                    ticketQueueCode = result.getOrThrow()
                } else {
                    result.getOrElse {
                        exceptionHandler(it)
                    }
                }
            }
        }
    }

    private fun exceptionHandler(e: Throwable) {
        e.printStackTrace()
    }
}