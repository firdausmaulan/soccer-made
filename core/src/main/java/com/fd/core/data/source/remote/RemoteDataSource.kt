package com.fd.core.data.source.remote

import android.util.Log
import com.fd.core.data.source.remote.network.ApiResponse
import com.fd.core.data.source.remote.network.ApiService
import com.fd.core.data.source.remote.response.TeamResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RemoteDataSource(private val apiService: ApiService) {

    suspend fun getTeams(idLeague : String): Flow<ApiResponse<List<TeamResponse>>> {
        //get data from remote api
        return flow {
            try {
                val response = apiService.getTeams(idLeague)
                val dataArray = response?.teams
                if (dataArray?.isNotEmpty() == true) {
                    emit(ApiResponse.Success(response.teams))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }
}