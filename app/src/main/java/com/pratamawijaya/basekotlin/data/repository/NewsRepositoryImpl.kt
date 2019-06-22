package com.pratamawijaya.basekotlin.data.repository

import com.pratamawijaya.basekotlin.data.database.dao.ArticleDao
import com.pratamawijaya.basekotlin.data.mapper.ArticleMapper
import com.pratamawijaya.basekotlin.data.services.NewsServices
import com.pratamawijaya.basekotlin.domain.Article

open class NewsRepositoryImpl(private val service: NewsServices,
                              private val articleDao: ArticleDao,
                              private val articleMapper: ArticleMapper) : NewsRepository {

    override suspend fun getTopHeadlines(): List<Article> {
        return service.getTopHeadlinesAsync("id").await()
                .flatMap {
                    it.articles
                }
                .map { articleMapper.mapToDomain(it) }
    }

    override suspend fun getEverything(forceUpdate: Boolean, query: String, page: Int): List<Article> {
        return service.getEverythingAsync(query, page, pageSize = 20).await()
                .flatMap { it.articles }
                .map { articleMapper.mapToDomain(it) }
    }
}