package com.micahnyabuto.thera

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class TheraApp: Application() {
    override fun onCreate() {
        super.onCreate()
    }
}