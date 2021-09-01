package com.fd.core.di

import com.fd.core.BuildConfig
import com.fd.core.data.source.remote.network.ApiService
import okhttp3.CertificatePinner
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {
    single {
        val hostname = BuildConfig.HOST_NAME
        val certificatePinner = CertificatePinner.Builder()
            .add(hostname, BuildConfig.SSL_PIN1)
            .add(hostname, BuildConfig.SSL_PIN2)
            .build()
        val client = OkHttpClient.Builder()
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .certificatePinner(certificatePinner)
        if (BuildConfig.DEBUG) {
            client.addInterceptor(
                HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
            )
        }
        client.build()
    }
    single {
        val hostname = BuildConfig.BASE_URL
        val retrofit = Retrofit.Builder()
            .baseUrl(hostname)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
        retrofit.create(ApiService::class.java)
    }
}