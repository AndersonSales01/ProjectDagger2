package com.example.anderson.projectdagger2.di

import com.example.anderson.projectdagger2.data.repository.IRepoGitHub
import com.example.anderson.projectdagger2.data.repository.RepoGitHubImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class DataModule {

    // Nessa funcao estou dizendo pro dagger se alguem tiver precisando de uma interface IRepoGitHub, entao dagger retorna RepoGitHubImpl.
    @Singleton
    @Binds
    abstract fun provideGitHubRepository(repository: RepoGitHubImpl): IRepoGitHub
}