package com.example.anderson.projectdagger2.feature.di

import com.example.anderson.projectdagger2.feature.listgithub.ui.GitHubActivity
import dagger.Subcomponent

@Subcomponent(modules = [ViewModelModule::class])
interface UiComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): UiComponent
    }
    fun inject(activity: GitHubActivity)
}