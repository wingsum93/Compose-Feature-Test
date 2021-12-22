package com.ericho.composefeatureproj.base

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ericho.composefeatureproj.R
import com.ericho.composefeatureproj.ui.theme.AppTheme

private val screens = listOf("Find Restaurants", "My Points", "Saved Food", "My Account")

@Composable
fun CraneDrawer(
    modifier: Modifier = Modifier
) {
    Column(
        modifier
            .background(color = MaterialTheme.colors.primary)
            .fillMaxSize()
            .padding(start = 24.dp, top = 12.dp)
    ) {
        Image(
            modifier = modifier,
            painter = painterResource(R.drawable.ic_baseline_fastfood_24),
            contentDescription = "",
            colorFilter = ColorFilter.tint(
                MaterialTheme.colors.onPrimary
            )
        )
        for (screen in screens) {
            Spacer(Modifier.height(24.dp))
            Text(
                modifier = modifier,
                text = screen,
                color = MaterialTheme.colors.onPrimary,
                style = MaterialTheme.typography.h4
            )
        }
    }
}

@RequiresApi(Build.VERSION_CODES.S)
@Preview
@Composable
fun CraneDrawerPreview() {
    AppTheme {
        CraneDrawer()
    }
}
