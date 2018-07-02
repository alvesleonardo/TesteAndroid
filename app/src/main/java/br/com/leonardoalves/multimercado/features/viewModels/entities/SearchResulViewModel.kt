package br.com.leonardoalves.multimercado.features.viewModels.entities

import com.squareup.moshi.Json

class SearchResulViewModel(
        @Json(name = "address") var address:String,
        @Json(name = "latitude")var latitude:Double,
        @Json(name = "longitude")var longitude:Double
)