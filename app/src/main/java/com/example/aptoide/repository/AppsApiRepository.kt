package com.example.aptoide.repository

import android.util.Log
import com.example.aptoide.model.AppsDataset
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

interface AppsApiRepository {
    fun getApps(): Single<AppsDataset>
}

class AppsApiRepositoryImpl(private val api: AptoideApi) : AppsApiRepository {

    override fun getApps(): Single<AppsDataset> {
        return api.getApps()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnError { e ->
                Log.d("TAG", "doOnError ${e.localizedMessage}")
            }
    }
}