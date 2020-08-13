package com.yethiha.newsapp_kt.API

import com.yethiha.newsapp_kt.model.News
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {


    private  val BASE_URL = "http://newsapi.org/v2/"

  // val apiInterface:NewsApiInterface
    val apiInterface:NewsApiInterface


    // constrator
    init {
      var  retrofit= Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
        apiInterface = retrofit.create(NewsApiInterface::class.java)
    }

    fun getTopHeadLines():Call<News>{

        return apiInterface.getTopHeadlines("us","95fd30be6dd547c882e9e7f93433b3e9")
    }

}