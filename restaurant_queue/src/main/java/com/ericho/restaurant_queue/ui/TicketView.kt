package com.ericho.restaurant_queue.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.ericho.composefeatureproj.model.SeatQueue
import kotlinx.coroutines.launch

@OptIn(ExperimentalCoilApi::class)
@Composable
@Preview
fun TicketView(
    items: List<SeatQueue>
) {
    val scope = rememberCoroutineScope()
    Column {
        Text(text = "Your Ticket")
        Text(text = "Choose You numbers")
        Column(modifier = Modifier.fillMaxWidth()) {
            for (item in items) {
                Row(modifier = Modifier
                    .clickable {
                        scope.launch {
//                            navController.navigate("live/${item.key}")
                        }
                    }
                    .fillMaxWidth()) {
                    Image(
                        painter = rememberImagePainter(data = item.pic),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(5.dp)
                            .width(50.dp)
                            .height(50.dp)
                    )
                    Column(
                        modifier = Modifier
                            .padding(10.dp)
                            .align(Alignment.CenterVertically)
                    ) {
                        Text(text = item.title, modifier = Modifier)
                    }
                }
            }
        }
    }

}