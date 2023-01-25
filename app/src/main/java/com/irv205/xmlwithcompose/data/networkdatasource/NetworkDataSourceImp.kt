package com.irv205.xmlwithcompose.data.networkdatasource

import com.irv205.xmlwithcompose.data.mapper.toDomainModel
import com.irv205.xmlwithcompose.data.networkdatasource.service.RickAndMortyService
import com.irv205.xmlwithcompose.domain.model.CharacterDomain
import com.irv205.xmlwithcompose.domain.response.DataResponse
import com.irv205.xmlwithcompose.domain.service.NetworkDataSource
import javax.inject.Inject

class NetworkDataSourceImp @Inject constructor(
    private val service: RickAndMortyService): NetworkDataSource {

    override suspend fun getCharacters(page: Int): DataResponse<List<CharacterDomain>> {
        val response = service.getCharater(page)
        return DataResponse.Success(response.toDomainModel())
    }

}