package com.example.newsfeedapp.data

import com.example.newsfeedapp.common.INetworkAwareHandler
import com.example.newsfeedapp.data.model.Article
import com.example.newsfeedapp.data.sources.homeCachedData.IOfflineDataSource
import com.example.newsfeedapp.data.sources.remoteApi.IOnlineDataSource

class NewsRepository(

    private val offlineDataSource: IOfflineDataSource,
    private val onlineDataSource: IOnlineDataSource,
    private val networkHandler: INetworkAwareHandler) {

    suspend fun getNewsSources() : List<Article> {

        return if (networkHandler.isOnline()) {
            offlineDataSource.deleteAllNews()
            val data = onlineDataSource.getArticles()
            offlineDataSource.cacheArticles(data)
            data
        } else {
            offlineDataSource.getArticles()
        }
    }
}