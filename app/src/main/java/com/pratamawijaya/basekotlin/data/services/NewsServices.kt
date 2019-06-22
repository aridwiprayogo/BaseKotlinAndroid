package com.pratamawijaya.basekotlin.data.services

import com.pratamawijaya.basekotlin.data.response.TopHeadlineResponse
import io.reactivex.Single
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsServices {

    @GET("top-headlines")
    fun getTopHeadlinesAsync(@Query("country") country: String): Deferred<List<TopHeadlineResponse>>

    @GET("everything")
    fun getEverythingAsync(@Query("q") query: String, @Query("page") page: Int, @Query("pageSize") pageSize: Int): Deferred<List<TopHeadlineResponse>>
}