package com.yethiha.newsapp_kt.model

data class News(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)