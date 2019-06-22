package com.pratamawijaya.basekotlin.data.repository

import com.pratamawijaya.basekotlin.domain.Article

interface NewsRepository {
    suspend fun getTopHeadlines(): List<Article>
    suspend fun getEverything(forceUpdate: Boolean = false, query: String, page: Int): List<Article>
}