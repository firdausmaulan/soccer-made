package com.fd.core.domain.usecase

import com.fd.core.data.Resource
import com.fd.core.domain.model.Team
import com.fd.core.domain.repository.ITeamRepository
import kotlinx.coroutines.flow.Flow

class TeamInteractor(private val teamRepository: ITeamRepository) : TeamUseCase {

    override fun getTeams(idLeague: String): Flow<Resource<List<Team>>> =
        teamRepository.getTeams(idLeague)

    override fun getFavoriteTeams(): Flow<List<Team>> =
        teamRepository.getFavoriteTeams()

    override suspend fun setFavoriteTeam(team: Team, loved: Int) =
        teamRepository.setFavoriteTeam(team, loved)
}