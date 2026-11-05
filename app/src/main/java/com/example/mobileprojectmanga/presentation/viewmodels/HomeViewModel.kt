package com.example.mobileprojectmanga.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobileprojectmanga.data.MangaCard
import com.example.mobileprojectmanga.repositories.MangaRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(private val mangaRepository: MangaRepository = MangaRepository): ViewModel() {

    private val _uiState: MutableStateFlow<HomeUIState> = MutableStateFlow(HomeUIState(listOf(), null))
    val uiState: StateFlow<HomeUIState> = _uiState.asStateFlow()

//    private val _mangaList : MutableStateFlow<List<MangaCard>> = MutableStateFlow(listOf())
//    val mangaList: StateFlow<List<MangaCard>> = _mangaList.asStateFlow()
//
//    private val _mangaDetail : MutableStateFlow<MangaCard?> = MutableStateFlow(null)
//    val mangaDetail: StateFlow<MangaCard?> = _mangaDetail.asStateFlow()

    fun fetchCards(){
        viewModelScope.launch {
            _uiState.update {currentState ->
                currentState.copy(isLoading=true)
            }
            val manga = mangaRepository.getManga()
            //val testManga: List<MangaCard> = _manga.value
//            _mangaList.update { manga }
            // _manga.value=cards;

//            var filteredManga=manga.filter((item){
//
//            })

            _uiState.update {currentState ->
                currentState.copy(mangaList = manga, isLoading = false)
            }
        }


    }

    fun fetchCardDetail(id: Int){
        viewModelScope.launch {
            _uiState.update {currentState ->
                currentState.copy(isLoading=true)
            }
            val manga=mangaRepository.getMangaDetail(id)
//            _mangaDetail.update { manga }

            _uiState.update {currentState ->
                currentState.copy(mangaDetail = manga, mangaList = emptyList(), isLoading = false)
            }
        }
    }
}