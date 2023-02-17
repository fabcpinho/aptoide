package com.example.aptoide

import com.example.aptoide.mockdata.appsDatasetMockData
import com.example.aptoide.repository.AppsApiRepository
import com.example.aptoide.view.home.viewmodel.HomeViewModel
import io.mockk.every
import io.mockk.mockk
import io.reactivex.Single
import junit.framework.TestCase.assertTrue
import org.junit.Test

class HomeViewModelTest {
    private val repo = mockk<AppsApiRepository>()
    private val viewModel = HomeViewModel(repo)

    @Test
    fun getApps_updates_apps_flow() {
        every { viewModel.getApps() } returns Unit
        every { repo.getApps() } returns Single.just(appsDatasetMockData)
        viewModel.getApps()
        assertTrue(viewModel.apps.value.size == 2)
    }

    @Test
    fun getApps_orders_items() {
        every { viewModel.getApps() } returns Unit
        every { repo.getApps() } returns Single.just(appsDatasetMockData)
        viewModel.getApps()
        assertTrue(viewModel.apps.value[0].rating == 3.4f)
        assertTrue(viewModel.apps.value[1].rating == 2.4f)
    }
}