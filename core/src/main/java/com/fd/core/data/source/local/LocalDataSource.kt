package com.fd.core.data.source.local

import com.fd.core.data.source.local.database.TeamDao
import com.fd.core.data.source.local.entity.TeamEntity
import kotlinx.coroutines.flow.Flow

class LocalDataSource(private val teamDao: TeamDao) {

    fun getTeams(idLeague : String): Flow<List<TeamEntity>> = teamDao.getTeams(idLeague)

    fun getFavoriteTeams(): Flow<List<TeamEntity>> = teamDao.getFavoriteTeams()

    suspend fun insertTeams(teamList: List<TeamEntity>) = teamDao.insert(teamList)

    suspend fun setFavoriteTeam(team: TeamEntity, loved: Int) {
        team.intLoved = loved
        teamDao.updateFavoriteTeam(team)
    }
}