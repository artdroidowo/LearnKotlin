package com.example.karol.learnkotlin.model

import com.google.gson.annotations.SerializedName

data class Continue(
        val sroffset: Int,
        @SerializedName("continue")
        val _continue: String
)