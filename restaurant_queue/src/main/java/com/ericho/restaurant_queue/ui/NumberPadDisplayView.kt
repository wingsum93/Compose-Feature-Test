package com.ericho.restaurant_queue.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun NumberPadDisplayView(
    text: String,
    modifier: Modifier = Modifier
) {
    Spacer(modifier = Modifier.width(10.dp))
    Box(
        modifier = modifier
            .size(150.dp, 50.dp)
    ) {
        Text(
            text = text,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp, 0.dp)
                .align(Alignment.Center),
            textAlign = TextAlign.End,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview
@Composable
fun previewNumberDisplayView() {
    NumberPadDisplayView(
        "778",
        Modifier
            .width(190.dp)
            .height(70.dp)
    )
}