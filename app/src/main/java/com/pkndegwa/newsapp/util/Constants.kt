package com.pkndegwa.newsapp.util

import com.pkndegwa.newsapp.BuildConfig

class Constants {
    companion object {
        const val APIKEY = BuildConfig.API_KEY
        const val BASE_URL = "https://newsapi.org/"
        const val SEARCH_NEWS_TIME_DELAY = 500L
    }
}