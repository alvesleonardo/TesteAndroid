package br.com.leonardoalves.dataInfrastructure.infraestructure

import br.com.leonardoalves.dataInfrastructure.data.entities.CellsItem
import br.com.leonardoalves.dataInfrastructure.data.entities.FundResponse
import io.reactivex.Flowable
import io.reactivex.Single

interface SantanderHerokuDomain {

    fun getFormCells(): Flowable<CellsItem?>
    fun getFounds(): Single<FundResponse>
}