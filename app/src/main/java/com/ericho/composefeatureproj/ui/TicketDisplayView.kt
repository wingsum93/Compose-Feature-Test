package com.ericho.composefeatureproj.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun TicketDisplayView() {
    Column() {
        Text("No of people waiting:")
        Text(text = "12")
    }
}