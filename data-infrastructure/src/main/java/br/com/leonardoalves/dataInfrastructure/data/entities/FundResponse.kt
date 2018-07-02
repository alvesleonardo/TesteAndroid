package br.com.leonardoalves.dataInfrastructure.data.entities

import com.squareup.moshi.Json

data class FundResponse(

	@Json(name="screen")
	val screen: Screen? = null
)