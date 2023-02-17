package com.example.aptoide.di

import com.example.aptoide.repository.AppsApiRepository
import com.example.aptoide.repository.AppsApiRepositoryImpl
import com.example.aptoide.repository.api.AptoideApi
import com.example.aptoide.view.details.viewmodel.DetailsViewModel
import com.example.aptoide.view.home.viewmodel.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val appsModule = module {
    factory { provideRetrofit() }
    single { provideNetworkApi(get()) }

    single<AppsApiRepository> {
        AppsApiRepositoryImpl(
            api = get()
        )
    }
    viewModel { HomeViewModel(get()) }
    viewModel { DetailsViewModel() }
}

fun provideRetrofit(): Retrofit {
    return Retrofit.Builder()
        .baseUrl(NetworkConstants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
}

fun provideNetworkApi(retrofit: Retrofit): AptoideApi =
    retrofit.create(AptoideApi::class.java)


