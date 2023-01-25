package com.irv205.xmlwithcompose.presentation

sealed class MainViewState{
    object GetCharacter: MainViewState()
    object EmptyList: MainViewState()
    class ShowProgress(val show: Boolean): MainViewState()
    class Error(val message: String): MainViewState()
}