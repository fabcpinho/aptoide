package com.example.aptoide.view.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import com.example.aptoide.R
import com.example.aptoide.ui.theme.grayBackground
import com.example.aptoide.view.appbar.AppBar
import com.example.aptoide.view.details.viewmodel.DetailsViewModel

@Composable
fun DetailsComposeView(viewModel: DetailsViewModel = viewModel()) {
    val app = viewModel.appInfo.collectAsState().value
    Column(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        AppBar(hasBackNavigation = true, title = stringResource(id = R.string.details))

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
