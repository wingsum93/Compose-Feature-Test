package com.ericho.composefeatureproj.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import com.ericho.composefeatureproj.R
import com.ericho.composefeatureproj.base.CraneDrawer
import kotlinx.coroutines.launch

@Composable
fun AppPageWithM2(
    title: String,
    content: @Composable (PaddingValues) -> Unit,
) {
    val scaffoldState: ScaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
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
                },
                navigationIcon = {
                    val painter = painterResource(R.drawable.ic_baseline_fastfood_24)
                    IconButton(onClick = {
                        scope.launch {
                            scaffoldState.drawerState.open()
                        }
                    }) {
                        Image(
                            painter = painter, contentDescription = "",
                            colorFilter = ColorFilter.tint(MaterialTheme.colors.onPrimary)
                        )
                    }
                }
            )
        },
        contentColor = MaterialTheme.colors.onPrimary,
        scaffoldState = scaffoldState,
        drawerContent = {
            CraneDrawer()
        },
        content = content
    )
}