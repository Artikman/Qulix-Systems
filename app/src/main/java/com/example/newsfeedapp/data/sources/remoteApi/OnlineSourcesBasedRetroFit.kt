package com.example.newsfeedapp.data.sources.remoteApi

import android.util.Log
import com.example.newsfeedapp.data.model.Article
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*

class OnlineSourcesBasedRetroFit(private val service: IApiHelper) : IOnlineDataSource {

    private val articlesNews = mutableListOf<Article>()

    companion object {
        var errorMsg: String = ""
    }

    override suspend fun getArticles(): List<Article> {
        service.getarticles("the-next-web")
            .zip(service.getarticles("associated-press")) { firstSource, secondSource ->
                val allArticlesFromApi = mutableListOf<Article>()
                firstSource.articles?.let { allArticlesFromApi.addAll(it) }
                secondSource.articles?.let { allArticlesFromApi.addAll(it) }
                return@zip allArticlesFromApi
            }.flowOn(Dispatchers.IO)
            .catch { e ->
                errorMsg = e.message.toString()
                Log.e("TAG", errorMsg)
            }
            .collect {
                articlesNews.addAll(it)
            }
        return articlesNews
    }
}