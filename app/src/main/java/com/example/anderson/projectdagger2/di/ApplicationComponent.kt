package com.example.anderson.projectdagger2.di

import android.content.Context
import com.example.anderson.projectdagger2.feature.di.UiComponent
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import javax.inject.Singleton

//Onde sera iniciado todas as dependencias do dagger
@Singleton
@Component(modules = [DataModule::class, ViewModelBuilderModule::class, SubcomponentsModule::class])
interface ApplicationComponent {
    // Esse factory serve para passar contexto da aplicacao e o BindsInstance permite dar um "this", entao na minha classe application vai ser passado contexto
    // da aplicação para que possa ser usado nas classes.
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): ApplicationComponent
    }

    fun uiComponent(): UiComponent.Factory
}

@Module(subcomponents = [UiComponent::class])
object SubcomponentsModule