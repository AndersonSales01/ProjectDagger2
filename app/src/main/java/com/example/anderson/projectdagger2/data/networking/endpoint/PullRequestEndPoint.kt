package com.example.anderson.projectdagger2.data.networking.endpoint

import com.example.anderson.repository.model.entityrequest.PullRequestDTO
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by Anderson on 06/09/2020.
 */
interface PullRequestEndPoint {

    @GET("repos/{login}/{name}/pulls")
     fun callPullRequest(@Path("login") loginOwner: String, @Path("name") nameRepository: String): Deferred<List<PullRequestDTO>>
}