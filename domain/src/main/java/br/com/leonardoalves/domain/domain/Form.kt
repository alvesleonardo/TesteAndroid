package br.com.leonardoalves.domain.domain

import br.com.leonardoalves.dataInfrastructure.data.entities.CellsItem
import io.reactivex.Flowable

interface Form {
    fun getForm():Flowable<CellsItem>
    fun sendFormResponse()
}