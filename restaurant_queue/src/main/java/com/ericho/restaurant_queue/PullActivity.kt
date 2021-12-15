package com.ericho.restaurant_queue

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
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
                        NumberPad(
                            modifier = Modifier
                                .padding(20.dp)
                                .align(Alignment.Center)
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
}

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
                        .align(Alignment.Center)
                )
            }
        }
    }
}