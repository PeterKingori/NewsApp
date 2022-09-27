package com.pkndegwa.smartherdnewsapp.repository

import com.pkndegwa.smartherdnewsapp.api.RetrofitInstance
import com.pkndegwa.smartherdnewsapp.db.ArticleDatabase
import com.pkndegwa.smartherdnewsapp.models.Article

class NewsRepository(private val db: ArticleDatabase) {
    suspend fun getBreakingNews(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getTopHeadlines(countryCode, pageNumber)

    suspend fun searchNews(searchQuery: String, pageNumber: Int) =
        RetrofitInstance.api.searchNews(searchQuery, pageNumber)

    suspend fun upsert(article: Article) = db.getArticleDao().upsert(article)

    fun getSavedNews() = db.getArticleDao().getAllArticles()

    suspend fun deleteArticle(article: Article) = db.getArticleDao().deleteArticle(article)
}