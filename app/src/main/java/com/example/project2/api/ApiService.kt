package com.example.project2.api


import com.example.project2.model.ResponseWrapper
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("articlesearch.json/")
    fun getArticles(
        @Query("api-key") value: String?): Call<ResponseWrapper>?
}