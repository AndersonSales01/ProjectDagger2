package com.example.anderson.projectdagger2.feature.di

import androidx.lifecycle.ViewModel
import com.example.anderson.projectdagger2.di.ViewModelKey
import com.example.anderson.projectdagger2.feature.pullrequest.viewmodel.PullRequestViewModel
import com.example.anderson.projectdagger2.feature.github.viewmodel.GitHubViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(GitHubViewModel::class)
    fun bindGitHubViewModel(viewModel: GitHubViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(PullRequestViewModel::class)
    fun bindPullRequestViewModel(viewModel: PullRequestViewModel): ViewModel
}