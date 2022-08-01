package com.pkndegwa.newsapp.ui

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.pkndegwa.newsapp.repository.NewsRepository

class NewsViewModelProviderFactory(private val app: Application, private val newsRepository: NewsRepository): ViewModelProvider
.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NewsViewModel(app, newsRepository) as T
    }
}