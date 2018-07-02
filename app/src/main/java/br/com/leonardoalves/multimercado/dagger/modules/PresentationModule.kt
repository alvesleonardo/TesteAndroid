package br.com.leonardoalves.multimercado.dagger.modules

import br.com.leonardoalves.multimercado.features.presenters.investmentFragment.InvestmentPresenter
import br.com.leonardoalves.multimercado.features.presenters.investmentFragment.InvestmentView
import br.com.leonardoalves.multimercado.features.presenters.mainActivity.MainActivityInterface
import br.com.leonardoalves.multimercado.features.presenters.mainActivity.MainActivityPresenter
import dagger.Module
import dagger.Provides

@Module(includes = [(InteractorsModule::class)])
class PresentationModule {
    @Provides
    fun mainPresenter(viewInterface: MainActivityInterface):MainActivityPresenter{
        return MainActivityPresenter(viewInterface)
    }

    @Provides fun investmentPresenter(viewInterface:InvestmentView): InvestmentPresenter {
        return InvestmentPresenter(viewInterface)
    }
}