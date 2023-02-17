package com.example.aptoide.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.aptoide.ui.theme.AptoideTheme
import com.example.aptoide.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


/**
 * General considerations:
 * - Used MVVM architecture since it handles view state automatically
 * - Koin for dependency injection
 * - Jetpack compose for UI
 * - Applied an alpha on the images on editors choice to provide better visualizatoin of the white text
 * but it's still not a great design implementation. Opted by keeping it similar to the requirement.
 * - Resource qualifier for translations added: PT e EN
 */
class MainActivity : ComponentActivity() {
    private val viewModel by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getApps()
        setContent {
            AptoideTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AptoideComposeView()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AptoideTheme {
        AptoideComposeView()
    }
}