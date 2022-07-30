package com.pkndegwa.newsapp.api

import com.pkndegwa.newsapp.models.NewsResponse
import com.pkndegwa.newsapp.util.Constants.Companion.APIKEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * A public interface that exposes [getTopHeadlines] and [searchNews] methods.
 */
interface NewsApi {
    @GET("v2/top-headlines")
    suspend fun getTopHeadlines(
        @Query("country")
        countryCode: String = "us",
        @Query("page")
        pageNumber: Int = 1,
        @Query("apiKey")
        apiKey: String = APIKEY
    ): Response<NewsResponse>

    @GET("v2/everything")
    suspend fun searchNews(
        @Query("q")
        searchQuery: String,
        @Query("page")
        pageNumber: Int = 1,
        @Query("apiKey")
        apiKey: String = APIKEY
    ): Response<NewsResponse>
}