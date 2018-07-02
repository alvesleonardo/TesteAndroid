package br.com.leonardoalves.multimercado.dagger.modules

import br.com.leonardoalves.multimercado.dagger.modules.activities.MainActivityModule
import br.com.leonardoalves.multimercado.features.ui.activities.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivitiesBuilder{
    @ContributesAndroidInjector(modules = [(MainActivityModule::class)])
    internal abstract fun mapsActivity(): MainActivity

}