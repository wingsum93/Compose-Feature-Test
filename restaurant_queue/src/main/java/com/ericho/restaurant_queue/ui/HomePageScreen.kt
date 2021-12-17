package com.ericho.restaurant_queue.ui

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter
import com.ericho.restaurant_queue.PullViewModel
import com.ericho.restaurant_queue.R
import com.ericho.restaurant_queue.Route

@ExperimentalAnimationApi
@Composable
fun HomePageScreen(
    navHostController: NavHostController,
    vm: PullViewModel = PullViewModel()
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        val displayString = remember { mutableStateOf("") }
        val imagePainter = rememberImagePainter(R.drawable.bg_burger_101)
        Image(
            painter = imagePainter,
            contentDescription = null,
            modifier = Modifier
                .size(120.dp)
                .align(Alignment.TopCenter)
        )
        NumberPad(
            modifier = Modifier
                .padding(20.dp)
                .align(Alignment.Center),
            displayNumberState = displayString,
            onNumberClick = {
                val nextValue = displayString.value + it
                if (canEnterThisDigit(nextValue)) {
                    displayString.value = nextValue
                }
            },
            onEnterClick = { numberOfPeople ->
                vm.getTicket(numberOfPeople)
                navHostController.navigate(Route.WAITING)
            },
            onResetClick = {
                displayString.value = ""
            }
        )
    }

}

private fun canEnterThisDigit(currentString: String): Boolean {
    return try {
        val inputNumber = currentString.toInt()
        return inputNumber in 1..10
    } catch (e: NumberFormatException) {
        false
    }
}