package com.ericho.restaurant_queue.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberImagePainter
import com.ericho.restaurant_queue.PullViewModel
import com.ericho.restaurant_queue.R

@Composable
fun WaitingPage(
    navHostController: NavHostController,
    vm: PullViewModel = PullViewModel()
) {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxHeight()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Cyan)

        ) {
            val imagePainter = rememberImagePainter(R.drawable.bg_burger_with_beer)
            Image(
                painter = imagePainter,
                contentDescription = null,
                modifier = Modifier
                    .width(200.dp)
                    .aspectRatio(4f / 3f)
                    .align(Alignment.Center)
            )
        }
        val string = vm.flow.collectAsState(initial = "")
        Box {
            Text(
                text = "Waiting order $ AAA ",
                fontSize = 40.sp
            )

        }
    }

}

@Preview(showBackground = true)
@Composable
fun WaitingPagePreview() {
    val c = rememberNavController()
    WaitingPage(c)
}