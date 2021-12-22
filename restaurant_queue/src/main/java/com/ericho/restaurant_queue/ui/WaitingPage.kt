package com.ericho.restaurant_queue.ui

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.ericho.restaurant_queue.R

@Composable
fun WaitingPageUI(
    numberOfPeople: Int,
    ticketQueueNumber: String?,
    ticketReady: Boolean,
    onLeavePage: () -> Unit = {}
) {
    BackHandler {
        onLeavePage.invoke()
    }
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
                    .clip(RoundedCornerShape(percent = 10))
            )
        }
        Spacer(modifier = Modifier.height(50.dp))
        Box(Modifier.fillMaxWidth()) {
            Text(
                text = "Waiting order ($numberOfPeople)",
                fontSize = 24.sp,
                modifier = Modifier
                    .fillMaxWidth(.75f)
                    .align(Alignment.Center),
                style = MaterialTheme.typography.bodyLarge
            )
        }
        val queueNumberDisplayText = ticketQueueNumber ?: "Loading Ticket Code"
        Box(Modifier.fillMaxWidth()) {
            Text(
                text = queueNumberDisplayText,
                fontSize = 16.sp,
                modifier = Modifier
                    .fillMaxWidth(.75f)
                    .align(Alignment.Center),
                style = MaterialTheme.typography.bodySmall
            )
        }
        Spacer(modifier = Modifier.height(50.dp))
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
                    fontSize = 30.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .width(250.dp)
                        .align(Alignment.Center),
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun WaitingPagePreview() {
    WaitingPageUI(
        2,
        "8736b786595ae22195fd19ecc9dae02d",
        false
    )
}

@Preview(showBackground = true)
@Composable
fun WaitingPagePreview_order_ready() {
    WaitingPageUI(
        2,
        "8736b786595ae22195fd19ecc9dae02d",
        true
    )
}