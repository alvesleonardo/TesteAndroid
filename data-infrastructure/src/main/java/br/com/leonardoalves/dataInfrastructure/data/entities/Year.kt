package br.com.leonardoalves.dataInfrastructure.data.entities

import com.squareup.moshi.Json

data class Year(

	@Json(name="fund")
	val fund: Double? = null,

	@Json(name="CDI")
	val cDI: Double? = null
)