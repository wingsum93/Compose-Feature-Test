package com.ericho.composefeatureproj

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ericho.composefeatureproj.api.RestaurantRepo
import kotlinx.coroutines.launch

class MainViewModel constructor(val repo: RestaurantRepo) : ViewModel() {

    init {

    }


    fun loadDisplayData() {
        viewModelScope.launch {
            val result_1 = repo.checkQueueOfType(1)
            val result_2 = repo.checkQueueOfType(2)
            if (result_1.isSuccess) {
                result_1.getOrNull()?.code
            }
        }
    }
}