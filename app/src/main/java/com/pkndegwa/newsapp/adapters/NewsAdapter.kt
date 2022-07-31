package com.pkndegwa.newsapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.pkndegwa.newsapp.databinding.ItemArticlePreviewBinding
import com.pkndegwa.newsapp.models.Article
import java.text.SimpleDateFormat
import java.util.*

/**
 * Adapter for the RecyclerView in BreakingNewsFragment, SavedNewsFragment and SearchNewsFragment.
 */
class NewsAdapter : RecyclerView.Adapter<NewsAdapter.ArticleViewHolder>() {

    class ArticleViewHolder(private val binding: ItemArticlePreviewBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(article: Article) {
            Glide.with(binding.root).load(article.urlToImage).into(binding.articleImageView)
            binding.apply {
                sourceTextView.text = article.source.name
                titleTextView.text = article.title
                descriptionTextView.text = article.description
                publishedAtTextView.text = getFormattedDate(article.publishedAt)
            }
        }

        private fun getFormattedDate(date: String): String? {
            val formattedDate = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).parse(date)
            return formattedDate?.let { SimpleDateFormat("MMM dd, yyyy", Locale.getDefault()).format(it) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        return ArticleViewHolder(ItemArticlePreviewBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val article = differ.currentList[position]
        holder.bind(article)
        holder.itemView.setOnClickListener {
            onItemClickListener?.let { it(article) }
        }
    }

    private var onItemClickListener: ((Article) -> Unit)? = null

    // TODO: Check if this function is used anywhere in the project
    private fun setOnItemClickListener(listener: (Article) -> Unit) {
        onItemClickListener = listener
    }

    private val differCallback = object : DiffUtil.ItemCallback<Article>() {
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem.url == newItem.url
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)
}