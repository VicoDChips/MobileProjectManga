package com.example.mobileprojectmanga.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation3.runtime.NavKey
import com.example.mobileprojectmanga.app.AppButton
import com.example.mobileprojectmanga.app.Filter
import com.example.mobileprojectmanga.presentation.viewmodels.HomeViewModel

@Composable
fun HomeListPage(onItemClick: Any,
    homeViewModel: HomeViewModel =viewModel()
) {
    val uiState=homeViewModel.uiState.collectAsStateWithLifecycle()

    val filter : Filter = Filter()

    LaunchedEffect(true) {
        homeViewModel.fetchMangaList(filter)
    }

    Column {
        if (uiState.value.isLoading){
            Text(
                text = "Chargement en cours"
            )
        }else{
            uiState.value.error?.let{ error ->
                Text(
                    color = Color.Red,
                    text ="erreur: $error"
                )
            }
            val count=uiState.value.mangaList.count()
            Text(
                text = "Nombre de manga $count"
            )
            AppButton(
                text = "Recharger les manga",
                modifier = Modifier.padding(top=30.dp)
            ){
                homeViewModel.fetchMangaList(filter)
            }
        }
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