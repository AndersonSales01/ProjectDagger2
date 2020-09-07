package com.example.anderson.projectdagger2.feature.di

import com.example.anderson.projectdagger2.feature.pullrequest.ui.activity.PullRequestActivity
import com.example.anderson.projectdagger2.feature.github.ui.activity.GitHubActivity
import dagger.Subcomponent

@Subcomponent(modules = [ViewModelModule::class])
interface SubComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): SubComponent
    }
    fun inject(activity: GitHubActivity)
    fun inject(activity: PullRequestActivity)
}