package com.ericho.restaurant_queue.ui

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@ExperimentalAnimationApi
@Composable
fun NumberPad(
    modifier: Modifier = Modifier,
    displayNumberState: State<String>,
    onNumberClick: (Int) -> Unit = {},
    onEnterClick: (numberOfPeople: String) -> Unit = {},
    onResetClick: () -> Unit = {}
) {
    Column(modifier = modifier) {
        AnimatedContent(targetState = displayNumberState.value) { text ->
            NumberPadDisplayView(
                text,
                Modifier
                    .width(220.dp)
                    .height(70.dp)
            )
        }
        Row(
            modifier = Modifier
            //.fillMaxHeight(0.3f)
        ) {
            Spacer(modifier = Modifier.width(10.dp))
            NumberPadButton(
                "1"
            ) { onNumberClick.invoke(1) }
            Spacer(modifier = Modifier.width(10.dp))
            NumberPadButton(
                "2"
            ) { onNumberClick.invoke(2) }
            Spacer(modifier = Modifier.width(10.dp))
            NumberPadButton(
                "3"
            ) { onNumberClick.invoke(3) }
            Spacer(modifier = Modifier.width(10.dp))
        }
        Spacer(modifier = Modifier.height(5.dp))
        Row(
            modifier = Modifier
            //.fillMaxHeight(0.3f)
        ) {
            Spacer(modifier = Modifier.width(10.dp))
            NumberPadButton(
                "4"
            ) { onNumberClick.invoke(4) }
            Spacer(modifier = Modifier.width(10.dp))
            NumberPadButton(
                "5"
            ) { onNumberClick.invoke(5) }
            Spacer(modifier = Modifier.width(10.dp))
            NumberPadButton(
                "6"
            ) { onNumberClick.invoke(6) }
            Spacer(modifier = Modifier.width(10.dp))
        }
        Spacer(modifier = Modifier.height(5.dp))
        Row(
            modifier = Modifier
            //.fillMaxHeight(0.3f)
        ) {
            Spacer(modifier = Modifier.width(10.dp))
            NumberPadButton(
                "7"
            ) {
                onNumberClick.invoke(7)
            }
            Spacer(modifier = Modifier.width(10.dp))
            NumberPadButton(
                "8"
            ) {
                onNumberClick.invoke(8)
            }
            Spacer(modifier = Modifier.width(10.dp))
            NumberPadButton(
                "9"
            ) { onNumberClick.invoke(9) }
            Spacer(modifier = Modifier.width(10.dp))
        }
        Spacer(modifier = Modifier.height(5.dp))
        Row(
            modifier = Modifier
            //.fillMaxHeight(0.3f)
        ) {
            Spacer(modifier = Modifier.width(10.dp))
            NumberPadButton(
                "0"
            ) { onNumberClick.invoke(0) }
            Spacer(modifier = Modifier.width(10.dp))
            NumberPadBigButton(
                "Reset",
                Modifier.width(130.dp)
            ) { onResetClick.invoke() }
            Spacer(modifier = Modifier.width(10.dp))
        }
        Row(
            modifier = Modifier
                .padding(0.dp, 10.dp)
        ) {
            Spacer(modifier = Modifier.width(10.dp))
            NumberPadBigButton(
                "Get Ticket",
                Modifier.width(200.dp)
            ) { onEnterClick.invoke(displayNumberState.value) }
            Spacer(modifier = Modifier.width(10.dp))
        }
    }
}

@ExperimentalAnimationApi
@SuppressLint("UnrememberedMutableState")
@Preview
@Composable
fun SeeNumberPad() {
    NumberPad(
        modifier = Modifier.padding(20.dp),
        displayNumberState = mutableStateOf("")
    )
}