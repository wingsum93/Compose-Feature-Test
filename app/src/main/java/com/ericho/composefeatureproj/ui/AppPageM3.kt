package com.ericho.composefeatureproj.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.material.TopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController

@ExperimentalMaterial3Api
@Composable
fun AppPageWithM3(
    title: String,
    navController: NavController,
    content: @Composable (PaddingValues) -> Unit,
) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row {
                        Text(
                            text = title,
                            color = Color.White
                        )
                    }
                }
            )
        },
        content = content
    )
}