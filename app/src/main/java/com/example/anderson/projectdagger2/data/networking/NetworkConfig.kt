package com.example.anderson.projectdagger2.data.networking

import android.content.Context
import com.example.anderson.projectdagger2.constants.Constants
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object NetworkConfig {
    lateinit var context: Context

    fun <T> provideApi(clazz: Class<T>, context: Context?): T {

        val retrofit = Retrofit
            .Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constants.BASEURL)
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .client(okhttpClient(context)) // Add our Okhttp client
            .build()

        return retrofit.create(clazz)
    }

    private fun okhttpClient(context: Context?): OkHttpClient {
        return OkHttpClient.Builder()
            .readTimeout(40, TimeUnit.SECONDS)
            .connectTimeout(40, TimeUnit.SECONDS)
           // .addInterceptor(AuthInterceptor(context))
            .build()
    }

}