package br.com.leonardoalves.dataInfrastructure.data.entities

import com.squareup.moshi.Json

data class DownInfoItem(

	@Json(name="data")
	val data: Any? = null,

	@Json(name="name")
	val name: String? = null
)