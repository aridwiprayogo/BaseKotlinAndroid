package com.pratamawijaya.basekotlin.screens.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.github.ajalt.timberkt.d
import com.github.ajalt.timberkt.e
import com.pratamawijaya.basekotlin.data.repository.NewsRepository
import com.pratamawijaya.basekotlin.domain.Article
import com.pratamawijaya.basekotlin.screens.base.BaseViewModel
import com.pratamawijaya.basekotlin.shared.RxUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

sealed class HomeScreenState
object LoadingState : HomeScreenState()
data class ErrorState(var msg: String?) : HomeScreenState()
data class ArticleLoadedState(val articles: List<Article>) : HomeScreenState()

class HomeVM(val repo: NewsRepository) : BaseViewModel() {

    var homeState = MutableLiveData<HomeScreenState>()
    var listArticle = mutableListOf<Article>()

    fun getTopHeadlines() {
        homeState.value = LoadingState

        viewModelScope.launch {
            try {
                val result = repo.getTopHeadlines()
                homeState.value = ArticleLoadedState(result)
            }catch (throwable: Throwable){
                onError(throwable)
            }finally {

            }
        }
    }

    fun getEverything(query: String, page: Int) {
        homeState.value = LoadingState

        viewModelScope.launch {
            try {
                val result = repo.getEverything(query = query, page = page)
                homeState.value = ArticleLoadedState(result)
                d { "article size ${listArticle.size}" }
            }catch (throwable: Throwable){
                onError(throwable)
            }
        }
    }

    override fun onError(error: Throwable) {
        e { "error ${error.localizedMessage}" }
        homeState.value = ErrorState(error.localizedMessage)
    }
}