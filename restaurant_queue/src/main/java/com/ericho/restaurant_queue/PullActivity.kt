package com.ericho.restaurant_queue

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.ericho.composefeatureproj.ui.AppPage
import com.ericho.composefeatureproj.ui.theme.ComposeFeatureProjTheme
import com.ericho.restaurant_queue.ui.TicketView
import com.google.android.play.core.splitcompat.SplitCompat
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PullActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeFeatureProjTheme {
                // A surface container using the 'background' color from the theme
                AppPage("Instant App") {
                    TicketView(emptyList())
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