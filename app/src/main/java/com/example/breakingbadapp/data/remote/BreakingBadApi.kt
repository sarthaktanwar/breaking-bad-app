package com.example.breakingbadapp.data.remote

import com.example.breakingbadapp.domain.model.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface BreakingBadApi {

    // get("/breakingbad/characters")
    //get("/breakingbad/characters/search")


    @GET("/breakingbad/characters")
    suspend fun getAllCharacters(
        @Query("page")page : Int=1
    ):ApiResponse

    @GET("/breakingbad/characters/search")
    suspend fun searchCharacters(
        @Query("name")name :String
    ):ApiResponse
}