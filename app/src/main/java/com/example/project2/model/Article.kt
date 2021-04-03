package com.example.project2.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Article (
        @SerializedName("web_url")
        @Expose
        var webUrl: String= "",
        @SerializedName("article_title")
        @Expose
        var articleTitle: String= "",
        @SerializedName("article_snippet")
        @Expose
        var articleSnippet: String= ""
)