package com.fd.core.di

import com.fd.core.data.TeamRepository
import com.fd.core.data.source.local.LocalDataSource
import com.fd.core.data.source.remote.RemoteDataSource
import com.fd.core.domain.repository.ITeamRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { LocalDataSource(get()) }
    single { RemoteDataSource(get()) }
    single<ITeamRepository> {
        TeamRepository(
            get(),
            get()
        )
    }
}