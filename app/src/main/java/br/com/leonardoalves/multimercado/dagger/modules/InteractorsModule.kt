package br.com.leonardoalves.multimercado.dagger.modules

import br.com.leonardoalves.dataInfrastructure.infraestructure.SantanderHerokuDomain
import br.com.leonardoalves.domain.domain.Form
import br.com.leonardoalves.domain.interactors.FormUseCase
import dagger.Module
import dagger.Provides

@Module(includes = [InfrastructureModule::class])
class InteractorsModule {
    @Provides
    fun searchLocation(santanderHerokuDomain: SantanderHerokuDomain):Form{
        return FormUseCase(santanderHerokuDomain)
    }
}