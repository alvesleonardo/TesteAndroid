package br.com.leonardoalves.dataInfrastructure.data.entities

import com.squareup.moshi.Json

data class CellsItem(

	@Json(name="typefield")
	val typefield: String? = null,

	@Json(name="hidden")
	val hidden: Boolean? = null,

	@Json(name="show")
	val show: String? = null,

	@Json(name="id")
	val id: Int? = null,

	@Json(name="type")
	val type: Int? = null,

	@Json(name="message")
	val message: String? = null,

	@Json(name="topSpacing")
	val topSpacing: Double? = null,

	@Json(name="required")
	val required: Boolean? = null
)