package com.example.project2.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class Doc(
        @SerializedName("web_url")
        @Expose
        var webUrl: String= "",
        @SerializedName("snippet")
        @Expose
        var snippet: String= "",
        @SerializedName("lead_paragraph")
        @Expose
        var leadParagraph: String= "",
        @SerializedName("multimedia")
        @Expose
        var multimedia: List<Multimedium?> = listOf(),
        @SerializedName("headline")
        @Expose
        var headline: Headline? = null,
        @SerializedName("keywords")
        @Expose
        var keywords: List<Keyword> = listOf(),
        @SerializedName("pub_date")
        @Expose
        val pubDate: String= "",
        @SerializedName("document_type")
        @Expose
        var documentType: String = "",
        @SerializedName("news_desk")
        @Expose
        var newsDesk: String = "",
        @SerializedName("id")
        @Expose
        var id: Int = 0
) {

    fun thumbnailUrl(): String? {
        multimedia?.forEach { medium ->
            if (medium?.subtype.equals("thumbnail"))
                return "https://www.nytimes.com/" + medium?.url
        }
        return null
    }
}