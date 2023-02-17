package com.example.aptoide.view.details

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import com.example.aptoide.R
import com.example.aptoide.ui.theme.aptoideEnd
import com.example.aptoide.ui.theme.aptoideStart
import com.example.aptoide.ui.theme.grayBackground
import com.example.aptoide.view.details.viewmodel.DetailsViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsComposeView(viewModel: DetailsViewModel = viewModel()) {
    val app = viewModel.appInfo.collectAsState().value
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        CenterAlignedTopAppBar(
            title = {
                Text(text = "Aptoide", textAlign = TextAlign.Center)
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

        Column(
            modifier = Modifier
                .weight(1f)
                .background(grayBackground)
        ) {
            Image(
                painter = rememberAsyncImagePainter(app.graphic),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop,
            )
            Column(modifier = Modifier.padding(all = 16.dp)) {
                SpecItem(
                    label = stringResource(id = R.string.name),
                    description = app.name.toString()
                )
                SpecItem(
                    label = stringResource(id = R.string.package_name),
                    description = app.packageName.toString()
                )
                SpecItem(
                    label = stringResource(id = R.string.downloads),
                    description = app.downloads.toString()
                )
                SpecItem(
                    label = stringResource(id = R.string.update),
                    description = app.updated.toString()
                )
                SpecItem(
                    label = stringResource(id = R.string.rating),
                    description = app.rating.toString()
                )
            }
        }
    }
}

@Composable
private fun SpecItem(
    modifier: Modifier = Modifier,
    label: String,
    description: String,
) {
    Row(
        modifier = modifier
            .padding(top = 12.dp),
        verticalAlignment = Alignment.CenterVertically,

        ) {
        Text(
            text = label,
            style = TextStyle(
                fontSize = 16.sp,
            ),
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.weight(1f))
        Text(
            modifier = Modifier.padding(start = 4.dp),
            text = description,
            color = Color.Gray,
            style = TextStyle(
                fontSize = 12.sp,
            ),
        )
    }
}
