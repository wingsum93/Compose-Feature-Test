package com.ericho.composefeatureproj.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable

@Composable
fun AppPage(
    title: String,
    content: @Composable (PaddingValues) -> Unit,
) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row {
                        Text(text = title)
                    }
                }
            )
        }, content = content
    )
}