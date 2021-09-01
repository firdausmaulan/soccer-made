package com.fd.soccer.di

import com.fd.soccer.ui.detail.TeamDetailViewModel
import com.fd.soccer.ui.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { TeamDetailViewModel(get()) }
}