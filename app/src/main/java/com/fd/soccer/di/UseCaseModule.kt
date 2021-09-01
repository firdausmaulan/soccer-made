package com.fd.soccer.di

import com.fd.core.domain.usecase.TeamInteractor
import com.fd.core.domain.usecase.TeamUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory<TeamUseCase> { TeamInteractor(get()) }
}