package com.example.newsfeedapp.common

import android.app.Application
import com.example.newsfeedapp.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApplication)
            modules(listOf(roomModule, glideModule, networkModule, viewModelModule, apiServiceModule, repoModule))
        }
    }
}