package br.com.leonardoalves.multimercado.dagger.components

import android.app.Application
import br.com.leonardoalves.multimercado.MultiMercadoApplication
import br.com.leonardoalves.multimercado.dagger.modules.ActivitiesBuilder
import br.com.leonardoalves.multimercado.dagger.modules.AppModule
import br.com.leonardoalves.multimercado.dagger.modules.FragmentBuilder
import br.com.leonardoalves.multimercado.dagger.modules.RestWebServiceModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [(AndroidInjectionModule::class), (AppModule::class), (RestWebServiceModule::class),(ActivitiesBuilder::class), (FragmentBuilder::class)])
interface AppComponent {
    @Component.Builder
    interface Builder{
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }
    abstract fun inject(target: MultiMercadoApplication)
}