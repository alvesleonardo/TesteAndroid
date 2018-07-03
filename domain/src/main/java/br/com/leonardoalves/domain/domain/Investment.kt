package br.com.leonardoalves.domain.domain

import br.com.leonardoalves.dataInfrastructure.data.entities.FundResponse
import br.com.leonardoalves.dataInfrastructure.data.entities.Screen
import io.reactivex.Single

interface Investment {
    fun getInvestmentData(): Single<Screen?>?
}