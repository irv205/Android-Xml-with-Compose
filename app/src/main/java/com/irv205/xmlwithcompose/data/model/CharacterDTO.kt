package com.irv205.xmlwithcompose.data.model

import com.google.gson.annotations.SerializedName

data class CharacterResponseDTO(
    @SerializedName("results")
    val result: List<CharacterDTO>
)

data class CharacterDTO(
    @SerializedName("id")
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val image: String
)