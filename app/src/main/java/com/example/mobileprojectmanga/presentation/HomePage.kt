package com.example.mobileprojectmanga.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.NavKey

@Composable
fun HomeListPage(onItemClick: Any) {
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