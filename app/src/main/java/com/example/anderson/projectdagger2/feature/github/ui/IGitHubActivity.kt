package com.example.anderson.projectdagger2.feature.github.ui

import com.example.anderson.projectdagger2.data.model.Repository

interface IGitHubActivity {
    fun toGoPullRequestScreen(repository: Repository)
}