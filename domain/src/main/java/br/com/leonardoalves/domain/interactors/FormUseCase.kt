package br.com.leonardoalves.domain.interactors

import br.com.leonardoalves.dataInfrastructure.data.entities.CellsItem
import br.com.leonardoalves.dataInfrastructure.infraestructure.SantanderHerokuDomain
import br.com.leonardoalves.domain.domain.Form
import br.com.leonardoalves.domain.domain.Investment
import io.reactivex.Flowable

class FormUseCase(private var santanderHerokuDomain: SantanderHerokuDomain): Form {
    override fun sendFormResponse() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getForm(): Flowable<CellsItem> {
        return santanderHerokuDomain.getFormCells()
                .filter { it != null }
                .map { it!! }
    }

}