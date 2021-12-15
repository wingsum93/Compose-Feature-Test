package com.ericho.restaurant_queue

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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
                val vm: PullViewModel = viewModel()

                // A surface container using the 'background' color from the theme
                AppPage("Instant App") {
                    NumberPad(
                        modifier = Modifier.padding(20.dp)
                    )
                }
            }
        }
    }

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(newBase)
        SplitCompat.install(this)
    }
}

@Composable
fun Greeting2(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    ComposeFeatureProjTheme {
        Greeting2("Android")
    }
}