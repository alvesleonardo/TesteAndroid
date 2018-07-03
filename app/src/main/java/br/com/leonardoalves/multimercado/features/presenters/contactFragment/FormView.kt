package br.com.leonardoalves.multimercado.features.presenters.contactFragment

import br.com.leonardoalves.dataInfrastructure.data.entities.CellsItem
import io.reactivex.Flowable

interface FormView {
    fun subscribeForm(subscribeOn: Flowable<CellsItem>)
}