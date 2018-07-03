package br.com.leonardoalves.multimercado.dagger.modules

import br.com.leonardoalves.dataInfrastructure.infraestructure.SantanderHerokuDomain
import br.com.leonardoalves.domain.domain.Form
import br.com.leonardoalves.domain.domain.Investment
import br.com.leonardoalves.domain.interactors.FormUseCase
import br.com.leonardoalves.domain.interactors.InvestmentUseCase
import dagger.Module
import dagger.Provides

@Module(includes = [InfrastructureModule::class])
class InteractorsModule {
    @Provides
    fun searchLocation(santanderHerokuDomain: SantanderHerokuDomain):Investment{
        return InvestmentUseCase(santanderHerokuDomain)
    }

    @Provides fun formUseCase(santanderHerokuDomain: SantanderHerokuDomain): Form {
        return FormUseCase(santanderHerokuDomain)
    }
}