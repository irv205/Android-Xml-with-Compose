package com.irv205.xmlwithcompose.domain.repository

import com.irv205.xmlwithcompose.domain.model.CharacterDomain
import com.irv205.xmlwithcompose.domain.response.DataResponse

interface RickAndMortyRepository {
    suspend fun getCharacters(page: Int): DataResponse<List<CharacterDomain>>
}