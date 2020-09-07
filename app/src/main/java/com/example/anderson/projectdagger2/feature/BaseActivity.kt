package com.example.anderson.projectdagger2.feature

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.anderson.projectdagger2.MyApplication
import com.example.anderson.projectdagger2.R
import com.example.anderson.projectdagger2.feature.di.SubComponent

abstract class BaseActivity : AppCompatActivity() {

    lateinit var subComponent: SubComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        subComponent = (applicationContext as MyApplication).appComponent.uiComponent().create()
    }

    abstract fun initialize()
    abstract fun initViews()
    abstract fun observables()
}