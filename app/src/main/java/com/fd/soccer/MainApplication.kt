package com.fd.soccer

import androidx.multidex.MultiDexApplication
import com.fd.core.di.databaseModule
import com.fd.core.di.networkModule
import com.fd.core.di.repositoryModule
import com.fd.soccer.di.useCaseModule
import com.fd.soccer.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MainApplication : MultiDexApplication() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@MainApplication)
            modules(
                listOf(
                    databaseModule,
                    networkModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule
                )
            )
        }
    }
}