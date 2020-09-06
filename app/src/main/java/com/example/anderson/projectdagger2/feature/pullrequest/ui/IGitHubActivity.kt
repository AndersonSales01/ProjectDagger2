package com.example.anderson.projectdagger2.feature.pullrequest.ui

import com.example.anderson.projectdagger2.data.model.Repository

interface IGitHubActivity {
    fun toGoPullRequestScrenn(repository: Repository)
}