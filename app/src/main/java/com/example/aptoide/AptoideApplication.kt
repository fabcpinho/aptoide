package com.example.aptoide

import android.app.Application
import com.example.aptoide.di.appsModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class AptoideApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@AptoideApplication)
            modules(appsModule)
        }
    }
}