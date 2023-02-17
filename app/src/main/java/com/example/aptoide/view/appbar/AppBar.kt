package com.example.aptoide.view.appbar

import android.app.Activity
import androidx.compose.foundation.background
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import com.example.aptoide.ui.theme.aptoideEnd
import com.example.aptoide.ui.theme.aptoideStart

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(hasBackNavigation: Boolean, title: String) {
    val context = LocalContext.current

    CenterAlignedTopAppBar(
        title = {
            Text(text = title, textAlign = TextAlign.Center)
        },
        modifier = Modifier
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        aptoideStart, aptoideEnd
                    )
                )
            ),
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = Color.Transparent,
            navigationIconContentColor = Color.White,
            titleContentColor = Color.White
        ),
        navigationIcon = {
            if (hasBackNavigation)
                IconButton(onClick = {
                    val activity = (context as? Activity)
                    activity?.finish()
                }) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Back",
                        tint = Color.White
                    )
                }
        }
    )
}