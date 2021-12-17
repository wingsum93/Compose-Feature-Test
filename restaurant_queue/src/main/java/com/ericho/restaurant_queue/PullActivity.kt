package com.ericho.restaurant_queue

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil.annotation.ExperimentalCoilApi
import com.ericho.composefeatureproj.ui.AppPage
import com.ericho.composefeatureproj.ui.theme.AppTheme
import com.ericho.restaurant_queue.ui.HomePageScreen
import com.ericho.restaurant_queue.ui.NumberPad
import com.ericho.restaurant_queue.ui.WaitingPageUI
import com.google.android.play.core.splitcompat.SplitCompat

@ExperimentalMaterial3Api
@RequiresApi(Build.VERSION_CODES.S)
@ExperimentalCoilApi
@ExperimentalAnimationApi
class PullActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                val pullViewModel: PullViewModel = viewModel()
                val navController = rememberNavController()
                // A surface container using the 'background' color from the theme
                AppPage("Instant App", navController = navController) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = Route.HOME,
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable(Route.HOME) {
                            HomePageScreen(navHostController = navController, vm = pullViewModel)
                        }
                        composable(Route.WAITING) {
                            WaitingPageView(navHostController = navController, vm = pullViewModel)
                        }
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

@RequiresApi(Build.VERSION_CODES.S)
@SuppressLint("UnrememberedMutableState")
@ExperimentalAnimationApi
@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    AppTheme {
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

@RequiresApi(Build.VERSION_CODES.S)
@Composable
@Preview(showBackground = true)
fun DefaultPreview3() {
    AppTheme {
        WaitingPageUI(numberOfPeople = "", ticketQueueNumber = "", false)
    }
}

@Composable
fun WaitingPageView(
    navHostController: NavHostController,
    vm: PullViewModel = PullViewModel()
) {
    val string = vm.flow.collectAsState(initial = "")
    WaitingPageUI(
        "",
        "",
        false
    )
}