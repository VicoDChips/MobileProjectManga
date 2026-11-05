package com.example.mobileprojectmanga.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation3.runtime.NavKey
import com.example.mobileprojectmanga.app.AppButton
import com.example.mobileprojectmanga.datasource.api.NetworkDataSource
import com.example.mobileprojectmanga.presentation.viewmodels.HomeViewModel
import com.example.mobileprojectmanga.ui.theme.Margin

@Composable
fun HomeListPage(onItemClick: Any,
    homeViewModel: HomeViewModel =viewModel()
) {
    val uiState=homeViewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(true) {
        homeViewModel.fetchCards()
    }
    Column {
        if (uiState.value.isLoading){
            Text(
                text = "Chargement en cours"
            )
        }
        val count=uiState.value.mangaList.count()
        Text(
            text = "Nombre de manga $count"
        )
    }
    AppButton(
        text = "Recharger les manga"
    ){
        homeViewModel.fetchCards()
    }
}

@Composable
fun HomeDetailPage(id: String, onBack: () -> NavKey?) {
    Column {
        Text(
            text = "Hello HomeDetailPage"
        )
    }
}