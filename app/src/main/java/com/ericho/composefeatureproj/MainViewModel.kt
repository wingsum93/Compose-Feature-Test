package com.ericho.composefeatureproj

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ericho.composefeatureproj.api.RestaurantRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch

@HiltViewModel
class MainViewModel : ViewModel() {

    val repo = RestaurantRepo()

//    val a = State

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