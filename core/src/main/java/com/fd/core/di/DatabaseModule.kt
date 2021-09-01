package com.fd.core.di

import androidx.room.Room
import com.fd.core.BuildConfig
import com.fd.core.data.source.local.database.AppDatabase
import net.sqlcipher.database.SQLiteDatabase
import net.sqlcipher.database.SupportFactory
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {
    factory { get<AppDatabase>().teamDao() }
    single {
        val passphrase: ByteArray = SQLiteDatabase.getBytes(BuildConfig.DB_PASSWORD.toCharArray())
        val factory = SupportFactory(passphrase)
        Room.databaseBuilder(
            androidContext(),
            AppDatabase::class.java, "soccer.db"
        ).fallbackToDestructiveMigration()
            .openHelperFactory(factory)
            .build()
    }
}