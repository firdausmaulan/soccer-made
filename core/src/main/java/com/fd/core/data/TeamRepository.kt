package com.fd.core.data

import com.fd.core.data.source.local.LocalDataSource
import com.fd.core.data.source.remote.RemoteDataSource
import com.fd.core.data.source.remote.network.ApiResponse
import com.fd.core.data.source.remote.response.TeamResponse
import com.fd.core.domain.model.Team
import com.fd.core.domain.repository.ITeamRepository
import com.fd.core.utils.DataMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class TeamRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : ITeamRepository {

    override fun getTeams(idLeague: String): Flow<Resource<List<Team>>> =
        object : NetworkBoundResource<List<Team>, List<TeamResponse>>() {
            override fun loadFromDB(): Flow<List<Team>> {
                return localDataSource.getTeams(idLeague).map {
                    DataMapper.mapEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<Team>?): Boolean = data == null || data.isEmpty()

            override suspend fun createCall(): Flow<ApiResponse<List<TeamResponse>>> =
                remoteDataSource.getTeams(idLeague)

            override suspend fun saveCallResult(data: List<TeamResponse>) {
                val teamList = DataMapper.mapResponsesToEntities(data)
                localDataSource.insertTeams(teamList)
            }
        }.asFlow()

    override fun getFavoriteTeams(): Flow<List<Team>> {
        return localDataSource.getFavoriteTeams().map {
            DataMapper.mapEntitiesToDomain(it)
        }
    }

    override suspend fun setFavoriteTeam(team: Team, loved: Int) {
        val teamEntity = DataMapper.mapDomainToEntity(team)
        withContext(Dispatchers.IO) { localDataSource.setFavoriteTeam(teamEntity, loved) }
    }
}

