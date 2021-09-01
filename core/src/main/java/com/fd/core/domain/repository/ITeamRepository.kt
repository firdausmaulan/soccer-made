package com.fd.core.domain.repository

import com.fd.core.data.Resource
import com.fd.core.domain.model.Team
import kotlinx.coroutines.flow.Flow

interface ITeamRepository {

    fun getTeams(idLeague : String): Flow<Resource<List<Team>>>

    fun getFavoriteTeams(): Flow<List<Team>>

    suspend fun setFavoriteTeam(team: Team, loved: Int)

}