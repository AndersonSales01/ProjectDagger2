package com.example.anderson.projectdagger2.data.networking.endpoint

import com.example.anderson.repository.model.entityrequest.ResponseDTO
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface GitHubEndPoint {

    @GET("search/repositories?q=language:Java&sort=stars")
    fun  listRepository( @Query("page") page: Int ): Deferred<ResponseDTO>
}