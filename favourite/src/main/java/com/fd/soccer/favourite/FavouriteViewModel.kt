package com.fd.soccer.favourite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.fd.core.domain.usecase.TeamUseCase

class FavouriteViewModel(teamUseCase: TeamUseCase) : ViewModel() {
    val favoriteTeams = teamUseCase.getFavoriteTeams().asLiveData()
}