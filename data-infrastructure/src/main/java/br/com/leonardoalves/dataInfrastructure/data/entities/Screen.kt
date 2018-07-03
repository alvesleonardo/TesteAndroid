package br.com.leonardoalves.dataInfrastructure.data.entities

import com.squareup.moshi.Json

data class Screen(

	@Json(name="riskTitle")
	val riskTitle: String? = null,

	@Json(name="infoTitle")
	val infoTitle: String? = null,

	@Json(name="whatIs")
	val whatIs: String? = null,

	@Json(name="definition")
	val definition: String? = null,

	@Json(name="risk")
	val risk: Int? = null,

	@Json(name="downInfo")
	val downInfo: List<InfoItem?>? = null,

	@Json(name="title")
	val title: String? = null,

	@Json(name="fundName")
	val fundName: String? = null,

	@Json(name="moreInfo")
	val moreInfo: MoreInfo? = null,

	@Json(name="info")
	val info: List<InfoItem?>? = null
)