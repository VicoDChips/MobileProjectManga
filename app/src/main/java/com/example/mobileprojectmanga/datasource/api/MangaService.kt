package com.example.mobileprojectmanga.datasource.api

import com.example.mobileprojectmanga.data.MangaCard
import com.example.mobileprojectmanga.data.MangaCards

import retrofit2.http.GET
import retrofit2.http.Path

interface MangaService{
    @GET("cards")
    suspend fun getMangaCards(): MangaCards

    @GET("cards/{id}")
    suspend fun getCard(@Path("id") idCard: Int): MangaCard

}
