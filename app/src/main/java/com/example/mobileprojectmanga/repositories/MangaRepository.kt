package com.example.mobileprojectmanga.repositories

import android.util.Log
import com.example.mobileprojectmanga.data.MangaCard
import com.example.mobileprojectmanga.datasource.api.NetworkDataSource

object MangaRepository {

    val networkService = NetworkDataSource.mangaService

    suspend fun getManga(): List<MangaCard>{
        val cards = networkService.getMangaCards().data
        Log.v("getManga", cards.toString())
        // TODO Save in database
        return cards
    }

    suspend fun getMangaDetail(id: Int): MangaCard{
        return networkService.getMangaDetail(id)
    }

}