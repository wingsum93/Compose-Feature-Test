package com.ericho.restaurant_queue

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ericho.composefeatureproj.api.RestaurantRepo
import com.ericho.composefeatureproj.di.Injection
import com.ericho.composefeatureproj.model.Queue
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class PullViewModel(
    private val repo: RestaurantRepo = Injection.provideRestaurantRepo()
) : ViewModel() {

    var numberOfPeople by mutableStateOf(0)
        private set

    var ticketQueueCode by mutableStateOf<Queue?>(null)
        private set

    var haveTable by mutableStateOf<Boolean>(false)
        private set

    private var checkingTableJob: Job? = null

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
            if (ticketQueueCode?.queueCode != null) {
                checkingTableStatus(ticketQueueCode?.queueCode)
            }
        }

    }

    private fun checkingTableStatus(queueCode: String?) {
        //start another table checking
        if (queueCode == null) return
//        checkingTableJob?.cancel()
        while (true) {
            checkingTableJob = viewModelScope.launch {
                val result = repo.checkQueueStatus(queueCode)
                Log.i(TAG, "checking table !!")
                if (result.isSuccess) {
                    Log.i(TAG, "have table !!")
                    haveTable = result.getOrThrow()
                } else {
                    result.getOrElse {
                        exceptionHandler(it)
                    }
                }
                delay(10 * 1000L)
            }
        }
    }

    private val TAG = "PullViewModel"
    private fun exceptionHandler(e: Throwable) {
        Log.e(TAG, "exceptionHandler", e)
    }
}