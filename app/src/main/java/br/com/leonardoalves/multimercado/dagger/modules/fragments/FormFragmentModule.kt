package br.com.leonardoalves.multimercado.dagger.modules.fragments

import br.com.leonardoalves.multimercado.dagger.modules.PresentationModule
import br.com.leonardoalves.multimercado.features.presenters.contactFragment.FormView
import br.com.leonardoalves.multimercado.features.ui.fragments.FormFragment
import dagger.Module
import dagger.Provides

@Module(includes = [(PresentationModule::class)])
class FormFragmentModule {
    @Provides
    fun formFragment(fragment: FormFragment): FormView{
        return fragment
    }
}