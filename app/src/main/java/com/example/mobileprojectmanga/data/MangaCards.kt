package com.example.mobileprojectmanga.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MangaCards(@SerialName("cards") val cardList: List<MangaCard>)

@Serializable
data class MangaCard(
    val name: String,
    val manaCost: String? = null,
    var colors: ArrayList<String> = arrayListOf(),
    var type: String? = null,
    var rarity: String? = null
)

