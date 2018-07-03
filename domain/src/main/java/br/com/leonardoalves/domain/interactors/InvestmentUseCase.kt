package br.com.leonardoalves.domain.interactors

import br.com.leonardoalves.dataInfrastructure.data.entities.Screen
import br.com.leonardoalves.dataInfrastructure.infraestructure.SantanderHerokuDomain
import br.com.leonardoalves.domain.domain.Investment
import io.reactivex.Single

class InvestmentUseCase(private var santanderHerokuDomain: SantanderHerokuDomain) : Investment {
    override fun getInvestmentData(): Single<Screen?>? {
        return santanderHerokuDomain.getFounds()
                .map { it.screen }
    }
}