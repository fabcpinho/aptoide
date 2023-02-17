package com.example.aptoide.view.home.viewmodel

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModel
import com.example.aptoide.model.AppInfo
import com.example.aptoide.repository.AppsApiRepository
import kotlinx.coroutines.flow.MutableStateFlow

@SuppressLint("CheckResult")
class HomeViewModel(private val repository: AppsApiRepository) : ViewModel() {
    val apps = MutableStateFlow(listOf(AppInfo()))
    fun getApps() {
        repository.getApps()
            .map { dataset ->
                val list = dataset.responses?.listApps?.datasets?.all?.data?.appInfo
                val sortedList = list?.sortedByDescending {
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
}