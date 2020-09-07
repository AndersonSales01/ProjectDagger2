package com.example.anderson.projectdagger2.di

import com.example.anderson.projectdagger2.data.repository.IRepoGitHub
import com.example.anderson.projectdagger2.data.repository.IRepoPullRquest
import com.example.anderson.projectdagger2.data.repository.RepoGitHubImpl
import com.example.anderson.projectdagger2.data.repository.RepoPullRequestImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class RepositoryModule {

    // Nessa funcao estou dizendo pro dagger se alguem tiver precisando de uma interface IRepoGitHub, entao dagger retorna RepoGitHubImpl.
    @Singleton
    @Binds
    abstract fun provideGitHubRepository(repository: RepoGitHubImpl): IRepoGitHub

    @Singleton
    @Binds
    abstract fun providePullRequestRepository(repository: RepoPullRequestImpl): IRepoPullRquest
}