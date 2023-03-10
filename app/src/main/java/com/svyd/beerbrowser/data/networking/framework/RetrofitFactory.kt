package com.svyd.beerbrowser.data.networking.framework

import com.svyd.beerbrowser.data.networking.ApiConstants
import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory

class RetrofitFactory {

    fun provideRetrofit(client: OkHttpClient, factory: Converter.Factory) =
        Retrofit.Builder()
            .baseUrl(ApiConstants.API_ENDPOINT)
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .addConverterFactory(factory)
            .client(client)
            .build()
}