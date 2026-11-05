package com.example.mobileprojectmanga.presentation.viewmodels

import android.R
import com.example.mobileprojectmanga.data.MangaCard

data class HomeUIState(val mangaList: List<MangaCard>, val mangaDetail: MangaCard?, val isLoading: Boolean = false)
