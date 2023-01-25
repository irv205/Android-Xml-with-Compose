package com.irv205.xmlwithcompose.data.repository

import com.irv205.xmlwithcompose.data.model.CharacterResponseDTO
import com.irv205.xmlwithcompose.domain.model.CharacterDomain
import com.irv205.xmlwithcompose.domain.repository.RickAndMortyRepository
import com.irv205.xmlwithcompose.domain.response.DataResponse
import com.irv205.xmlwithcompose.domain.service.NetworkDataSource
import javax.inject.Inject

class RepositoryImp @Inject constructor(
    private val networkDataSource: NetworkDataSource): RickAndMortyRepository {

    override suspend fun getCharacters(page: Int): DataResponse<List<CharacterDomain>> {
        return try {
            networkDataSource.getCharacters(page)
        } catch (e: Exception){
            DataResponse.OnFailure(e.message.toString())
        }
    }
}