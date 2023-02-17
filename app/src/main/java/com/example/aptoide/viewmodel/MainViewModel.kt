package com.example.aptoide.viewmodel

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModel
import com.example.aptoide.model.AppInfo
import com.example.aptoide.model.AppsDataset
import com.example.aptoide.repository.AppsApiRepository
import kotlinx.coroutines.flow.MutableStateFlow

@SuppressLint("CheckResult")
class MainViewModel(private val repository: AppsApiRepository) : ViewModel() {
    val apps = MutableStateFlow(listOf(AppInfo()))
    fun getApps() {
        repository.getApps()
            .map { dataset ->
                val list = dataset.responses?.listApps?.datasets?.all?.data?.appInfo
                val sortedList = list?.sortedBy {
                    it.rating
                }
                if (!sortedList.isNullOrEmpty())
                    apps.value = sortedList
            }
            .subscribe()
    }

    fun onMoreEditorsSelected() {
        // Would navigate to a view with all Editors Choice apps
    }

    fun onMoreLocalTopAppsSelected() {
        // Would navigate to a view with all Local Top apps
    }

    fun onCardClicked() {
        // Would navigate to app info
    }
}