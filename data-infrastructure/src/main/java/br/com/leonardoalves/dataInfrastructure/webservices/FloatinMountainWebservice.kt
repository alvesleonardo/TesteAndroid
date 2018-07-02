package br.com.leonardoalves.dataInfrastructure.webservices

import br.com.leonardoalves.dataInfrastructure.data.entities.CellsResponse
import br.com.leonardoalves.dataInfrastructure.data.entities.FundResponse
import io.reactivex.Single
import retrofit2.http.GET

interface FloatinMountainWebservice {
    companion object {
        val BASE_URL: String = "https://floating-mountain-50292.herokuapp.com/"
    }

   @GET("cells.json")
   fun getFormCells(): Single<CellsResponse>

    @GET("fund.json")
    fun getFunds(): Single<FundResponse>
}