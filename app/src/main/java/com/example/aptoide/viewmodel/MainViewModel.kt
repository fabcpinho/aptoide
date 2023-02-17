package com.example.aptoide.viewmodel

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModel
import com.example.aptoide.model.AppsDataset
import com.example.aptoide.repository.AppsApiRepository
import kotlinx.coroutines.flow.MutableStateFlow

@SuppressLint("CheckResult")
class MainViewModel(private val repository: AppsApiRepository) : ViewModel() {
    val apps = MutableStateFlow(AppsDataset())
    fun getApps() {
        repository.getApps()
            .doOnSuccess {
                apps.value = it
            }
            .subscribe()
    }

    fun onMoreEditorsSelected() {
    }

    fun onCardClicked() {
    }

    fun onMoreLocalTopAppsSelected() {
    }
}