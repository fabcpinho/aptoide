package com.example.aptoide.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import com.example.aptoide.R
import com.example.aptoide.model.AppsDataset
import com.example.aptoide.model.AppInfo
import com.example.aptoide.viewmodel.MainViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AptoideComposeView(viewModel: MainViewModel = viewModel()) {
    val apps = viewModel.apps.collectAsState().value

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
        )

        Column(
            modifier = Modifier
                .weight(1f)
                .background(grayBackground)
                .padding(8.dp)
        ) {

            HeaderWithMore(
                text = stringResource(id = R.string.editors_choice),
                modifier = Modifier.padding(
                    top = 12.dp
                )
            ) {
                viewModel.onMoreEditorsSelected()
            }
            EditorsChoiceList(viewModel, apps)

            HeaderWithMore(
                text = stringResource(id = R.string.local_top_apps),
                modifier = Modifier.padding(
                    top = 24.dp
                )
            ) {
                viewModel.onMoreLocalTopAppsSelected()
            }
            LocalTopAppsList(viewModel, apps)
        }
    }
}

@Composable
fun HeaderWithMore(
    modifier: Modifier = Modifier,
    text: String,
    moreClicked: () -> Unit
) {
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        HeaderText(text)
        Spacer(modifier = Modifier.weight(1f))
        MoreEditorsButton(moreClicked)
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LocalTopAppsList(viewModel: MainViewModel, apps: List<AppInfo>) {
    apps.let {
        LazyRow(modifier = Modifier) {
            items(count = it.size, itemContent = { item ->
                val currentItem = apps.get(item)

                Card(
                    modifier = Modifier
                        .width(120.dp),
                    onClick = { viewModel.onCardClicked() }
                ) {
                    val shape = RoundedCornerShape(8.dp)
                    Column(
                        modifier = Modifier
                            .background(color = Color.White)
                            .padding(6.dp)
                    ) {
                        Image(
                            painter = rememberAsyncImagePainter(currentItem.icon),
                            contentDescription = null,
                            modifier = Modifier
                                .height(100.dp)
                                .fillMaxWidth()
                                .clip(shape),
                            contentScale = ContentScale.Crop
                        )

                        Text(
                            modifier = Modifier
                                .padding(top = 8.dp)
                                .height(32.dp),
                            text = currentItem.name ?: "",
                            color = Color.Black,
                            style = TextStyle(
                                fontSize = 12.sp,

                                ),
                            fontWeight = FontWeight.Bold,
                            maxLines = 2
                        )
                        RatingRow(currentItem = currentItem, textColor = Color.Black)
                    }
                }
                Spacer(
                    modifier = Modifier
                        .height(200.dp)
                        .width(6.dp)
                )
            })
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditorsChoiceList(viewModel: MainViewModel, apps: List<AppInfo>) {
    apps?.let {
        LazyRow(modifier = Modifier) {
            items(count = it.size, itemContent = { item ->
                val currentItem = apps.get(item)

                Card(modifier = Modifier
                    .height(200.dp)
                    .width(300.dp),
                    onClick = { viewModel.onCardClicked() }) {

                    Box(modifier = Modifier) {
                        Image(
                            painter = rememberAsyncImagePainter(currentItem.graphic),
                            contentDescription = null,
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop,
                            alpha = 0.7f
                        )

                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(all = 12.dp)
                                .align(Alignment.BottomStart)
                            /*.background(
                                brush = Brush.verticalGradient(
                                    colors = listOf(
                                        Gray, White
                                    )
                                )
                            )*/
                        ) {
                            Text(
                                text = currentItem.name ?: "",
                                color = Color.White,
                                style = TextStyle(
                                    fontSize = 12.sp,
                                ),
                                fontWeight = FontWeight.Bold
                            )
                            RatingRow(
                                currentItem = currentItem,
                                textColor = Color.White
                            )
                        }


                    }
                }

                Spacer(
                    modifier = Modifier
                        .height(200.dp)
                        .width(6.dp)
                )
            })
        }

    }
}

@Composable
private fun RatingRow(modifier: Modifier = Modifier, currentItem: AppInfo, textColor: Color) {
    Row(
        modifier = modifier.padding(top = 4.dp),
        verticalAlignment = Alignment.CenterVertically,

        ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_star),
            contentDescription = "rating_star",
            tint = textColor
        )
        Text(
            modifier = Modifier.padding(start = 4.dp),
            text = currentItem.rating.toString(),
            color = textColor,
            style = TextStyle(
                fontSize = 10.sp,
            ),
        )
    }
}

@Composable
fun MoreEditorsButton(moreClicked: () -> Unit) =
    TextButton(onClick = { moreClicked.invoke() }) {
        Text(text = "MORE", color = more)
    }

@Composable
fun HeaderText(text: String) = Text(
    text = text,
    color = Color.Black,
    style = TextStyle(
        fontSize = 16.sp,
    ),
    fontWeight = FontWeight.Bold
)
