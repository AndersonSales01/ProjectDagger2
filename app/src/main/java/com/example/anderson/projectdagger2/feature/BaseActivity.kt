package com.example.anderson.projectdagger2.feature

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.anderson.projectdagger2.R

abstract class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    abstract fun initialize()
    abstract fun initViews()
    abstract fun observables()
}