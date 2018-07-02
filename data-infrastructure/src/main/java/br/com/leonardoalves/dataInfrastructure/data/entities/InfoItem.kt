package br.com.leonardoalves.dataInfrastructure.data.entities

import com.squareup.moshi.Json

data class InfoItem(

	@Json(name="data")
	val data: String? = null,

	@Json(name="name")
	val name: String? = null
)