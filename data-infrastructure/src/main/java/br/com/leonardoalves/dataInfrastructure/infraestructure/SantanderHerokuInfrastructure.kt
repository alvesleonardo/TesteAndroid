package br.com.leonardoalves.dataInfrastructure.infraestructure

import br.com.leonardoalves.dataInfrastructure.data.entities.CellsItem
import br.com.leonardoalves.dataInfrastructure.data.entities.FundResponse
import br.com.leonardoalves.dataInfrastructure.webservices.FloatinMountainWebservice
import io.reactivex.Flowable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

class SantanderHerokuInfrastructure(private var floatinMountainWebservice: FloatinMountainWebservice):SantanderHerokuDomain{
    override fun getFormCells(): Flowable<CellsItem?> {
        return floatinMountainWebservice.getFormCells()
                .filter { it.cells != null }
                .map { it.cells }
                .toFlowable()
                .flatMap { Flowable.fromIterable(it) }
    }

    override fun getFounds(): Single<FundResponse> {
        return floatinMountainWebservice.getFunds()
    }
}