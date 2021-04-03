package com.example.project2.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Multimedium (
        @Expose
        @SerializedName("with")
        var width: Int = 0,
        @SerializedName("url")
        @Expose
        var url: String? = null,
        @SerializedName("height")
        @Expose
        var height: Int = 0,
        @SerializedName("subtype")
        @Expose
        var subtype: String? = null,
        @SerializedName("type")
        @Expose
        var type: String? = null
)