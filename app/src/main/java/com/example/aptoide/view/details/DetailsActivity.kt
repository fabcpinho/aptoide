package com.example.aptoide.view.details

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.aptoide.model.AppInfo
import com.example.aptoide.ui.theme.AptoideTheme
import com.example.aptoide.view.details.viewmodel.DetailsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailsActivity : ComponentActivity() {
    private val viewModel by viewModel<DetailsViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (intent.hasExtra(DETAILS_INTENT)) {
            val appInfo = if (Build.VERSION.SDK_INT >= 33) {
                intent.getParcelableExtra(DETAILS_INTENT, AppInfo::class.java)
            } else {
                intent.getParcelableExtra(DETAILS_INTENT)
            }
            appInfo?.let {
                viewModel.presentAppInfo(appInfo)
            }
        }

        setContent {
            AptoideTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DetailsComposeView()
                }
            }
        }
    }

    companion object {
        const val DETAILS_INTENT = "app_details"
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AptoideTheme {
        DetailsComposeView()
    }
}