package com.example.karol.learnkotlin.model

import com.google.gson.annotations.SerializedName

data class SearchedRecords(
        val batchcomplete: String,
        @SerializedName("continue")
        val _continue: Continue,
        val query: Query
)