package com.ericho.restaurant_queue.ui

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ericho.composefeatureproj.ui.theme.AppTheme

@Composable
fun NumberPadDisplayView(
    text: String,
    modifier: Modifier = Modifier
) {
    Spacer(modifier = Modifier.width(10.dp))
    Box(
        modifier = modifier
            .size(150.dp, 60.dp)
            .padding(10.dp, 10.dp)
            .border(2.dp, MaterialTheme.colorScheme.outline)
            .background(MaterialTheme.colorScheme.onPrimary)
    ) {
        if (text == "") {
            // ui for not yet input no.
            Text(
                text = "Enter Number of People",
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Center)
                    .padding(5.dp),
                textAlign = TextAlign.Start,
                fontSize = 14.sp,
                color = MaterialTheme.colorScheme.primary,
            )
        } else {
            // ui for input no.
            Text(
                text = text,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Center)
                    .padding(5.dp),
                textAlign = TextAlign.End,
                fontSize = 26.sp,
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.ExtraBold
            )
        }
    }
}

@Preview
@Composable
fun previewNumberDisplayView() {
    NumberPadDisplayView(
        "1",
        Modifier
            .width(190.dp)
            .height(70.dp)
    )
}

@RequiresApi(Build.VERSION_CODES.S)
@Preview
@Composable
fun previewNumberDisplayView_init() {
    AppTheme {
        NumberPadDisplayView(
            "Get Ticket",
            Modifier
                .width(190.dp)
                .height(70.dp)
        )
    }
}

@Preview
@Composable
fun previewNumberDisplayView_3_digit() {
    NumberPadDisplayView(
        "123",
        Modifier
            .width(190.dp)
            .height(70.dp)
    )
}