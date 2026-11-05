package com.example.mobileprojectmanga.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation3.runtime.NavKey
import com.example.mobileprojectmanga.datasource.api.NetworkDataSource

@Composable
fun HomeListPage(onItemClick: Any) {
    LaunchedEffect(true) {
        val response = NetworkDataSource.mangaService.getMangaCards()
    }
    Column {
        Text(
            text = "Hello Discover"
        )
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