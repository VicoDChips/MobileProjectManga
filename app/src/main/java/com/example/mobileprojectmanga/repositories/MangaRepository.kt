package com.example.mobileprojectmanga.repositories

import android.util.Log
import com.example.mobileprojectmanga.data.MangaCard
import com.example.mobileprojectmanga.datasource.api.NetworkDataSource

object MangaRepository {

    val networkService = NetworkDataSource.mangaService

    suspend fun getManga(): Result<List<MangaCard>>{
        try {
            val cards = networkService.getMangaCards().data
            Log.v("getManga", cards.toString())
            // TODO Save in database
            return Result.success(cards)
        }catch (e: Exception){
            Log.e("getManga", e.toString())
            return Result.failure(e)
        }

    }

    suspend fun getMangaDetail(id: Int): Result<MangaCard>{
        try {
            return Result.success(networkService.getMangaDetail(id))
        } catch (e: Exception) {
            Log.e("getMangaDetail", e.toString())
            return Result.failure(e)
        }
    }

}