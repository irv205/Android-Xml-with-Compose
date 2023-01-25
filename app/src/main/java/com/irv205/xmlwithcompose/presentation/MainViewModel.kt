package com.irv205.xmlwithcompose.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.irv205.xmlwithcompose.core.di.IODispatcher
import com.irv205.xmlwithcompose.core.di.MainDispatcher
import com.irv205.xmlwithcompose.domain.model.CharacterDomain
import com.irv205.xmlwithcompose.domain.repository.RickAndMortyRepository
import com.irv205.xmlwithcompose.domain.response.DataResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: RickAndMortyRepository,
    @IODispatcher private val ioDispatcher: CoroutineDispatcher,
    @MainDispatcher private val mainDispatcher: CoroutineDispatcher
): ViewModel() {

    private val _mainViewState = MutableLiveData<MainViewState>()
    val mainViewState : LiveData<MainViewState> get() = _mainViewState
    val list = mutableListOf<CharacterDomain>()
    var pagination = 1

    init {
        getCharacterList(pagination)
    }

    fun setPaginationValue(){
        pagination ++
        getCharacterList(pagination)
    }

    fun getCharacterList(page: Int){
        _mainViewState.value = MainViewState.ShowProgress(true)
        viewModelScope.launch(ioDispatcher) {
            when(val result = repository.getCharacters(page)){
                is DataResponse.OnFailure -> {
                    withContext(mainDispatcher){
                        _mainViewState.value = MainViewState.Error(result.message)
                    }
                }
                is DataResponse.Success -> {
                    withContext(mainDispatcher){
                        _mainViewState.value = MainViewState.ShowProgress(false)
                        if (pagination == 0){
                            list.clear()
                        }
                        list.addAll(result.data)
                        _mainViewState.value = MainViewState.GetCharacter
                    }
                }
            }
        }
    }
}