package br.com.leonardoalves.dataInfrastructure.data.entities

import com.squareup.moshi.Json

data class CellsResponse(

	@Json(name="cells")
	val cells: List<CellsItem?>? = null
)