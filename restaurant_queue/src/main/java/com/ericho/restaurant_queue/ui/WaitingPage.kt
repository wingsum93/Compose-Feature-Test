package com.ericho.restaurant_queue.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.ericho.restaurant_queue.R

@Composable
fun WaitingPageUI(
    numberOfPeople: String,
    ticketQueueNumber: String,
    ticketReady: Boolean
) {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxHeight()
    ) {
        Spacer(modifier = Modifier.height(50.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            val imagePainter = rememberImagePainter(R.drawable.bg_burger_with_beer)
            Image(
                painter = imagePainter,
                contentDescription = null,
                modifier = Modifier
                    .width(300.dp)
                    .aspectRatio(16f / 9f)
                    .align(Alignment.Center)
            )
        }
        Spacer(modifier = Modifier.height(50.dp))
        Box(Modifier.fillMaxWidth()) {
            Text(
                text = "Waiting order ($numberOfPeople) $ticketQueueNumber",
                fontSize = 24.sp,
                modifier = Modifier
                    .fillMaxWidth(.5f)
                    .align(Alignment.Center)
            )
        }
        Spacer(modifier = Modifier.height(50.dp))
        ticketReady
        Box(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            if (!ticketReady) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .size(80.dp)
                        .align(Alignment.Center),
                    color = MaterialTheme.colorScheme.primary
                )

            } else {
                Text(
                    text = "Your ticket is ready",
                    modifier = Modifier
                        .width(250.dp)
                        .align(Alignment.Center)
                )
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun WaitingPagePreview() {
    WaitingPageUI(
        "2",
        "AAAAAAAA",
        false
    )
}

@Preview(showBackground = true)
@Composable
fun WaitingPagePreview_order_ready() {
    WaitingPageUI(
        "2",
        "AAAAAAAA",
        true
    )
}