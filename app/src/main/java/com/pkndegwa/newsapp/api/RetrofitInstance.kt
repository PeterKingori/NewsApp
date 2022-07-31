package com.pkndegwa.newsapp.api

import com.pkndegwa.newsapp.util.Constants.Companion.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * A Retrofit singleton class that enables API requests from any other class.
 */
class RetrofitInstance {
    companion object {
        private val retrofit by lazy {
            // Log Retrofit responses
            val logging = HttpLoggingInterceptor()
            logging.setLevel(HttpLoggingInterceptor.Level.BODY)
            val client = OkHttpClient.Builder()
                .addInterceptor(logging)
                .build()

            // Retrofit object with Gson converter
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
        }

        /**
         * A public Api object that exposes the lazy-initialized Retrofit service
         */
        val api: NewsApi by lazy {
            retrofit.create(NewsApi::class.java)
        }
    }
}