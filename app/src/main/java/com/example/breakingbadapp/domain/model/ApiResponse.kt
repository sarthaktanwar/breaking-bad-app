package com.example.breakingbadapp.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class ApiResponse(
    val success:Boolean,
    val message:String ?= null, // ? nullable
    val prevPage:Int?= null,
    val nextPage:Int?=null,
    val characters:List<Characters> = emptyList()
)