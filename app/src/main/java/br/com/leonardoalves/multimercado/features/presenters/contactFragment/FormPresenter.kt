package br.com.leonardoalves.multimercado.features.presenters.contactFragment

import br.com.leonardoalves.domain.domain.Form
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class FormPresenter(private var viewInterface: FormView, private var formUseCase: Form) {
    fun getForm(){
        val subscribeOn = formUseCase.getForm()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
        if (subscribeOn != null) {
            viewInterface.subscribeForm(subscribeOn)
        }
    }
}