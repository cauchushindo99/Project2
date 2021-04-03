package com.example.project2.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ResponseWrapper (
        @Expose
        @SerializedName("page")
        var page: Int = 0,
        @Expose
        @SerializedName("sort")
        var sort: String = "",
        @Expose
        @SerializedName("q")
        var search: String,
        @Expose
        @SerializedName("begin_date")
        var beginDate: String = "",
        @Expose
        @SerializedName("fq")
        var newDesk: String =""
)