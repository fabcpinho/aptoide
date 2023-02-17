package com.example.aptoide.repository

import com.example.aptoide.model.AppsDataset
import io.reactivex.Single
import retrofit2.http.GET

interface AptoideApi {

    @GET("api_list/listApps")
    fun getApps(): Single<AppsDataset>
}