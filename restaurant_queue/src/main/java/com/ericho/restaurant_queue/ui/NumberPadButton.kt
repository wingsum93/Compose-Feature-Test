package com.ericho.restaurant_queue.ui

import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun NumberPadButton(
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .size(50.dp)
    ) {
        Text(
            text = text
        )
    }
}

@Preview
@Composable
fun previewNumberButton() {
    NumberPadButton(
        "7",
        onClick = {}
    )
}