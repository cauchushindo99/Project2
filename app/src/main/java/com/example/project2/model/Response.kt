package com.example.project2.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Response (
        @Expose
        @SerializedName("docs")
        var docs: List<Doc> = listOf()
)
