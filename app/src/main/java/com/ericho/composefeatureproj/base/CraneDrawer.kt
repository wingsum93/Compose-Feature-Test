package com.ericho.composefeatureproj.base

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ericho.composefeatureproj.R

private val screens = listOf("Find Restaurants", "My Points", "Saved Food", "My Account")

@Composable
fun CraneDrawer(modifier: Modifier = Modifier) {
    Column(
        modifier
            .fillMaxSize()
            .padding(start = 24.dp, top = 24.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.ic_baseline_fastfood_24),
            contentDescription = ""
        )
        for (screen in screens) {
            Spacer(Modifier.height(24.dp))
            Text(text = screen, style = MaterialTheme.typography.h4)
        }
    }
}

@RequiresApi(Build.VERSION_CODES.S)
@Preview
@Composable
fun CraneDrawerPreview() {
    CraneDrawer()
}
