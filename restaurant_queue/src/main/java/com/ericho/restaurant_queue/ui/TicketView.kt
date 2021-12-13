package com.ericho.restaurant_queue.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material.ExtendedFloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun TicketView() {
    Column {
        Text(text = "Your Ticket")
        Text(text = "123")
        ExtendedFloatingActionButton(
            text = { Text(text = "Check Your Status") },
            onClick = { },
            icon = { Icon(Icons.Filled.Refresh, "Check Your Status") }
        )
        ExtendedFloatingActionButton(
            text = { Text(text = "ABC") },
            onClick = { },
            icon = { Icon(Icons.Filled.Refresh, "Check Your Status") }
        )
    }

}