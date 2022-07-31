package com.pkndegwa.newsapp.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.pkndegwa.newsapp.R
import com.pkndegwa.newsapp.ui.MainActivity
import com.pkndegwa.newsapp.ui.NewsViewModel

class SearchNewsFragment: Fragment(R.layout.fragment_search_news) {
    lateinit var viewModel: NewsViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).viewModel
    }
}