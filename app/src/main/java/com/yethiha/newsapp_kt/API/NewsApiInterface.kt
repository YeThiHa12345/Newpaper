package com.yethiha.newsapp_kt.API

import com.yethiha.newsapp_kt.model.News
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiInterface {


    @GET ("top-headlines")
    fun getTopHeadlines(

        @Query("country") country:String,
        @Query("apiKey") apikey:String

    ): Call<News>
}