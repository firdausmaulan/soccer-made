package com.fd.soccer.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fd.core.domain.model.Team
import com.fd.core.domain.usecase.TeamUseCase
import kotlinx.coroutines.launch

class TeamDetailViewModel(private val teamUseCase: TeamUseCase) : ViewModel() {
    fun setFavouriteTeam(team: Team, loved: Int) {
        viewModelScope.launch {
            teamUseCase.setFavoriteTeam(team, loved)
        }
    }
}