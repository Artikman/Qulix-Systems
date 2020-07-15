package com.example.newsfeedapp.data.sources.remoteApi

import com.example.newsfeedapp.data.model.NewsResponse
import kotlinx.coroutines.flow.Flow

interface IApiHelper {

    fun getarticles(source:String): Flow<NewsResponse>

}