package com.pkndegwa.newsapp.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.pkndegwa.newsapp.R
import com.pkndegwa.newsapp.ui.MainActivity
import com.pkndegwa.newsapp.ui.NewsViewModel

class BreakingNewsFragment: Fragment(R.layout.fragment_breaking_news) {
    // TODO: check if the viewModel can be created and used this way
//    private val viewModel: NewsViewModel by activityViewModels()

    lateinit var viewModel: NewsViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).viewModel
    }
}