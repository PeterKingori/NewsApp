package com.pkndegwa.smartherdnewsapp.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.pkndegwa.smartherdnewsapp.models.Article

/**
 * A public interface that exposes database access functions.
 */
@Dao
interface ArticleDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(article: Article): Long

    @Query("SELECT * FROM articles")
    fun getAllArticles(): LiveData<List<Article>>

    @Delete
    suspend fun deleteArticle(article: Article)
}