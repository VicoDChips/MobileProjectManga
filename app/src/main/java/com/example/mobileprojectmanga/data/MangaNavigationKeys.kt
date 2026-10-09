package com.example.mobileprojectmanga.data

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

enum class Tab { HOME, SEARCH, PROFILE }

@Serializable
sealed interface HomeKey : NavKey

@Serializable
data object HomeList : HomeKey

@Serializable
data class HomeDetail(val id: String) : HomeKey

@Serializable
data object SearchScreen : NavKey

@Serializable
data object ProfileScreen : NavKey
