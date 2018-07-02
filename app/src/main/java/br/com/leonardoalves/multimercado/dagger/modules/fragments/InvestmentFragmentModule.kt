package br.com.leonardoalves.multimercado.dagger.modules.fragments

import br.com.leonardoalves.multimercado.dagger.modules.PresentationModule
import br.com.leonardoalves.multimercado.features.presenters.investmentFragment.InvestmentView
import br.com.leonardoalves.multimercado.features.ui.fragments.InvestmentFragment
import dagger.Module
import dagger.Provides

@Module(includes = [(PresentationModule::class)])
class InvestmentFragmentModule {
    @Provides
    fun investmentFragment(fragment: InvestmentFragment): InvestmentView {
        return fragment
    }
}