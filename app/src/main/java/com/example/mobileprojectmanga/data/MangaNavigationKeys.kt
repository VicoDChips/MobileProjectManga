package com.example.mobileprojectmanga.data

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

enum class Tab { HOME, LIBRARY, FRIENDS, PROFILE }

@Serializable
sealed interface HomeKey : NavKey

@Serializable
data object DiscoverScreen : HomeKey

@Serializable
data class HomeDetail(val id: String) : HomeKey

@Serializable
data object LibraryScreen : NavKey

@Serializable
data object FriendsScreen : NavKey

@Serializable
data object ProfileScreen : NavKey
