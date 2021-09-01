package com.fd.core.data.source.remote.network

import com.fd.core.data.source.remote.response.TeamsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("lookup_all_teams.php")
    suspend fun getTeams(@Query("id") id: String): TeamsResponse?
}
