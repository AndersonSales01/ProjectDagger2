package com.example.anderson.projectdagger2.data.repository

import com.example.anderson.repository.model.entity.PullRequest
import com.example.anderson.repository.model.entityrequest.PullRequestDTO

interface IRepoPullRquest {

    suspend fun loadPullRequest(nameOwner: String, nameRepository: String): List<PullRequestDTO>
    fun testDagger()
}