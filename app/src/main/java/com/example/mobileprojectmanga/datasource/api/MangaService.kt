package com.example.mobileprojectmanga.datasource.api

import com.example.mobileprojectmanga.data.MangaCard
import com.example.mobileprojectmanga.data.MangaResponse

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MangaService{
    @GET("data/")
    suspend fun getMangaCards(
//        @Query("page") page: Int = 1,
//        @Query("page_size") pageSize: Int = 20
    ): MangaResponse

    @GET("data/{id}")
    suspend fun getMangaDetail(@Path("id") id: Int): MangaCard
}
