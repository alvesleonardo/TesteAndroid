package br.com.leonardoalves.multimercado.features.presenters.investmentFragment

import br.com.leonardoalves.dataInfrastructure.data.entities.Screen
import io.reactivex.Single

interface InvestmentView {
    fun subscribe(investmentData: Single<Screen?>?)
}