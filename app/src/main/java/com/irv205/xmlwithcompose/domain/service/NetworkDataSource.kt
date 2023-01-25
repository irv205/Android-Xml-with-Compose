package com.irv205.xmlwithcompose.domain.service

import com.irv205.xmlwithcompose.data.model.CharacterResponseDTO
import com.irv205.xmlwithcompose.domain.model.CharacterDomain
import com.irv205.xmlwithcompose.domain.response.DataResponse

interface NetworkDataSource {
    suspend fun getCharacters(page: Int): DataResponse<List<CharacterDomain>>
}