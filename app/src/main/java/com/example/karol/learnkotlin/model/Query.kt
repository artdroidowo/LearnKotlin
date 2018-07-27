package com.example.karol.learnkotlin.model

data class Query(
        val searchinfo: Searchinfo,
        val search: MutableList<Search>
)