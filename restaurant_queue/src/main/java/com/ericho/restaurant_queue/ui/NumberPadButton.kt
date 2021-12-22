package com.ericho.restaurant_queue.ui

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun NumberPadButton(
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            MaterialTheme.colorScheme.onSecondary,
            MaterialTheme.colorScheme.secondary
        ),
        modifier = modifier
            .size(60.dp)
            .border(1.dp, MaterialTheme.colorScheme.outline, shape = RoundedCornerShape(20.0.dp))
    ) {
        Text(
            text = text,
            fontSize = 20.sp,
            style = MaterialTheme.typography.labelLarge
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