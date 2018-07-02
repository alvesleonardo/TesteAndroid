package br.com.leonardoalves.dataInfrastructure.data.entities

import com.squareup.moshi.Json

data class MoreInfo(

	@Json(name="month")
	val month: Month? = null,

	@Json(name="year")
	val year: Year? = null,

	@Json(name="12months")
	val jsonMember12months: JsonMember12months? = null
)