package com.example.aptoide.view.details.viewmodel

import androidx.lifecycle.ViewModel
import com.example.aptoide.model.AppInfo
import kotlinx.coroutines.flow.MutableStateFlow

class DetailsViewModel : ViewModel() {

    val appInfo = MutableStateFlow(AppInfo())

    fun presentAppInfo(content: AppInfo){
        appInfo.value = content
    }

}