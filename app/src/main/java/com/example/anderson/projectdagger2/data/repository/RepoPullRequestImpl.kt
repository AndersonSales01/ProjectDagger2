package com.example.anderson.projectdagger2.data.repository

import android.content.Context
import android.util.Log
import com.example.anderson.projectdagger2.data.networking.NetworkConfig
import com.example.anderson.projectdagger2.data.networking.endpoint.GitHubEndPoint
import com.example.anderson.projectdagger2.data.networking.endpoint.PullRequestEndPoint
import com.example.anderson.repository.model.entity.PullRequest
import com.example.anderson.repository.model.entity.User

import java.util.ArrayList
import javax.inject.Inject

/**
 * Created by Anderson on 06/09/2020.
 */
class RepoPullRequestImpl @Inject constructor(val context: Context) : IRepoPullRquest {

    override suspend fun loadPullRequest(nameOwner: String, nameRepository: String) =
        NetworkConfig.provideApi(PullRequestEndPoint::class.java,context).callPullRequest(nameOwner, nameRepository).await()

    override fun testDagger() {
        Log.d("Dagger", "Pegou o DAgger")
    }
}