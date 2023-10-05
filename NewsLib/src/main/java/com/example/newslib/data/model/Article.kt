package com.example.newslib.data.model

data class Article(
    val count: Int,
    val lastItemIndex: Int,
    val page: Int,
    val results: List<Response>
)