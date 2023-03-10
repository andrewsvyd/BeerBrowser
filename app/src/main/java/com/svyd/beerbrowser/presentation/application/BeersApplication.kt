package com.svyd.beerbrowser.presentation.application

import android.app.Application
import com.svyd.beerbrowser.data.networking.framework.OkHttpClientFactory
import com.svyd.beerbrowser.data.networking.framework.RetrofitFactory
import com.svyd.beerbrowser.presentation.base.di.ScopedDependency
import retrofit2.Retrofit

class BeersApplication: Application(), ScopedDependency<Retrofit> {

    private lateinit var globalRetrofit: Retrofit

    override fun onCreate() {
        super.onCreate()
        initializeRetrofit()
        instance = this
    }

    private fun initializeRetrofit() {
        val httpClient = OkHttpClientFactory().provideOkHttpClient()
        globalRetrofit = RetrofitFactory().provideRetrofit(httpClient)
    }

    companion object {
        lateinit var instance: BeersApplication
            private set
    }

    override fun provideDependency(): Retrofit {
        return globalRetrofit
    }
}