package com.example.project2.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Keyword (
        @SerializedName("isMajor")
        @Expose
        var isMajor: String? = null,
        @SerializedName("rank")
        @Expose
        var rank: Int = 0,
        @SerializedName("name")
        @Expose
        var name: String? = null,
        @SerializedName("value")
        @Expose
        val value: String? = null
)