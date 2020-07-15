package com.example.newsfeedapp.data.sources.remoteApi

import com.example.newsfeedapp.data.model.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("v2/everything")
    suspend fun getArticlesNews(@Query("domains") sourceName: String,
                                @Query("from") startTime: String,
                                @Query("to") endTime: String,
                                @Query("pageSize") sorted: Int = 100): NewsResponse
}