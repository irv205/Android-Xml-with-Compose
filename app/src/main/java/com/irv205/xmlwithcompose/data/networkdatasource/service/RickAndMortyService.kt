package com.irv205.xmlwithcompose.data.networkdatasource.service

import com.irv205.xmlwithcompose.data.model.CharacterResponseDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface RickAndMortyService {

    @GET("character")
    suspend fun getCharater(
        @Query("page") page: Int
    ): CharacterResponseDTO
}