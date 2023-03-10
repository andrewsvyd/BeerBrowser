package com.svyd.beerbrowser.data.networking.framework

import com.svyd.beerbrowser.data.networking.ApiConstants
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

class OkHttpClientFactory {

    fun provideOkHttpClient() =
        OkHttpClient.Builder()
            .connectTimeout(ApiConstants.CONNECTION_TIME_OUT.toLong(), TimeUnit.SECONDS)
            .readTimeout(ApiConstants.READ_TIME_OUT.toLong(), TimeUnit.SECONDS)
            .writeTimeout(ApiConstants.WRITE_TIME_OUT.toLong(), TimeUnit.SECONDS)
            .build()
}