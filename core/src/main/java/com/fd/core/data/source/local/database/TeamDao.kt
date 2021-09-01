package com.fd.core.data.source.local.database

import androidx.room.*
import com.fd.core.data.source.local.entity.TeamEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TeamDao {

    @Query("SELECT * FROM team WHERE idLeague=:idLeague")
    fun getTeams(idLeague: String?): Flow<List<TeamEntity>>

    @Query("SELECT * FROM team WHERE intLoved = 1")
    fun getFavoriteTeams(): Flow<List<TeamEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(teams: List<TeamEntity>)

    @Update
    suspend fun updateFavoriteTeam(team: TeamEntity)
}
