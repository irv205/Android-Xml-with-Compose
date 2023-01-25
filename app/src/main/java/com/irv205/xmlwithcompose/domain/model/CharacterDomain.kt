package com.irv205.xmlwithcompose.domain.model


data class CharacterDomain(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val image: String
)