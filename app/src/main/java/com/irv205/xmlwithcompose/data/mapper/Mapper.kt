package com.irv205.xmlwithcompose.data.mapper

import com.irv205.xmlwithcompose.data.model.CharacterDTO
import com.irv205.xmlwithcompose.data.model.CharacterResponseDTO
import com.irv205.xmlwithcompose.domain.model.CharacterDomain

fun CharacterResponseDTO.toDomainModel(): List<CharacterDomain> {
    return this.result.map { it.toDomain() }
}

fun CharacterDTO.toDomain(): CharacterDomain{
    return CharacterDomain(
        id,
        name,
        status,
        species,
        type,
        gender,
        image)
}