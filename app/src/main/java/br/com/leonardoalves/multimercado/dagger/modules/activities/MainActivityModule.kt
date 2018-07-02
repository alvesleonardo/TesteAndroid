package br.com.leonardoalves.multimercado.dagger.modules.activities

import br.com.leonardoalves.multimercado.dagger.modules.PresentationModule
import br.com.leonardoalves.multimercado.features.presenters.mainActivity.MainActivityInterface
import br.com.leonardoalves.multimercado.features.ui.activities.MainActivity
import dagger.Module
import dagger.Provides

@Module (includes = [(PresentationModule::class)])
class MainActivityModule {
    @Provides
    fun mainActivityViewInjector(activity: MainActivity): MainActivityInterface {
        return activity
    }
}