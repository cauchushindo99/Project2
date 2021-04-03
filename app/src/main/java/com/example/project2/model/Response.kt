package com.example.project2.model

data class Response (
        @Expose
        @SerializedName("docs")
        var docs: List<Doc> = listOf()
)
