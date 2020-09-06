package com.example.anderson.projectdagger2

import android.app.Application
import com.example.anderson.projectdagger2.di.ApplicationComponent
import com.example.anderson.projectdagger2.di.DaggerApplicationComponent

class MyApplication : Application() {

    lateinit var appComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerApplicationComponent.factory().create(this)
    }
}