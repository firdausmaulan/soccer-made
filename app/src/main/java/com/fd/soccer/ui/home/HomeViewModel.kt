package com.fd.soccer.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.fd.core.data.Resource
import com.fd.core.domain.model.Team
import com.fd.core.domain.usecase.TeamUseCase

class HomeViewModel(private val teamUseCase: TeamUseCase) : ViewModel() {
    fun getTeams(idLeague: String): LiveData<Resource<List<Team>>> {
        return teamUseCase.getTeams(idLeague).asLiveData()
    }
}