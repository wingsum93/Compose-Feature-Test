package com.ericho.restaurant_queue.ui

import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun NumberPadBigButton(
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .defaultMinSize(100.dp, 50.dp)
    ) {
        Text(
            text = text
        )
    }
}

@Preview
@Composable
fun previewNumberBigButton() {
    NumberPadBigButton(
        "Enter",
        onClick = {}
    )
}