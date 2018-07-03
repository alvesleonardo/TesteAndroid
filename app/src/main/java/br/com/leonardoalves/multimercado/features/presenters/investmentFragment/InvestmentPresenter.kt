package br.com.leonardoalves.multimercado.features.presenters.investmentFragment

import br.com.leonardoalves.domain.domain.Investment

class InvestmentPresenter(private var viewInterface:InvestmentView,
                          private var investmentUseCase: Investment) {
    fun getContentData(){
        viewInterface.subscribe(investmentUseCase.getInvestmentData())
    }
}