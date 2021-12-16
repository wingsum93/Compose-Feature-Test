package com.ericho.restaurant_queue

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ericho.composefeatureproj.ui.AppPage
import com.ericho.composefeatureproj.ui.theme.ComposeFeatureProjTheme
import com.ericho.restaurant_queue.ui.NumberPad
import com.google.android.play.core.splitcompat.SplitCompat

class PullActivity : ComponentActivity() {
    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeFeatureProjTheme {
                val pullViewModel: PullViewModel = viewModel()

                // A surface container using the 'background' color from the theme
                AppPage("Instant App") {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight()
                    ) {
                        val displayString = remember { mutableStateOf("") }
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
                                pullViewModel.getTicket(numberOfPeople)
                            },
                            onResetClick = {
                                displayString.value = ""
                            }
                        )
                    }

                }
            }
        }
    }

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(newBase)
        SplitCompat.install(this)
    }

    private fun canEnterThisDigit(currentString: String): Boolean {
        return try {
            val inputNumber = currentString.toInt()
            return inputNumber in 1..10
        } catch (e: NumberFormatException) {
            false
        }
    }
}

@ExperimentalAnimationApi
@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    ComposeFeatureProjTheme {
        AppPage("Instant App") {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
            ) {
                NumberPad(
                    modifier = Modifier
                        .padding(20.dp)
                        .align(Alignment.Center),
                    displayNumberState = mutableStateOf("")
                )
            }
        }
    }
}