package com.example.mobileprojectmanga.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MangaResponse(
    val data: List<MangaCard>
)

@Serializable
data class MangaCard(
    @SerialName("__id") val id: Int,
    @SerialName("site_id") val siteId: Int,
    val url: String,
    val title: String,
    val letter: String? = null,
    val publisher: String? = null,
    val volumes: Int = 0,
    val artists: String? = null,
    val writers: String? = null,
    val genres: String? = null,
    @SerialName("cover_url") val coverUrl: String? = null,
    @SerialName("first_seen_at") val firstSeenAt: String? = null,
    @SerialName("last_seen_at") val lastSeenAt: String? = null
)
