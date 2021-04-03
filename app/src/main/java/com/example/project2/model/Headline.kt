package com.example.project2.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Headline (
        @SerializedName("main")
        @Expose
        var main: String? = null
)