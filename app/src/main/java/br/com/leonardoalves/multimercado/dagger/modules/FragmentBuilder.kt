package br.com.leonardoalves.multimercado.dagger.modules

import br.com.leonardoalves.multimercado.dagger.modules.fragments.FormFragmentModule
import br.com.leonardoalves.multimercado.dagger.modules.fragments.InvestmentFragmentModule
import br.com.leonardoalves.multimercado.features.ui.fragments.FormFragment
import br.com.leonardoalves.multimercado.features.ui.fragments.InvestmentFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilder {
    @ContributesAndroidInjector(modules = [(InvestmentFragmentModule::class)])
    internal abstract fun isvestmentFragment():InvestmentFragment

    @ContributesAndroidInjector(modules = [(FormFragmentModule::class)])
    internal abstract fun formFragment():FormFragment
}