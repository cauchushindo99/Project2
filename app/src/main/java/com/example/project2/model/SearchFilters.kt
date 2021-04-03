package com.example.project2.model

import android.content.ContentValues
import android.os.Parcelable
import android.util.Log
import kotlinx.android.parcel.Parcelize
import java.text.SimpleDateFormat
import java.util.*


const val SORT_OLDEST = "oldest"
const val SORT_NEWEST = "newest"
@Parcelize
data class SearchFilters (
        var newsDeskArts:String = "\"Arts\"",
        var newsDeskFashion:String = "\"Fashion\"",
        var newsDeskStyle:String = "\"Style\"",
        var newsDeskSport:String = "\"Sport\"",
        var ignoreBeginDate: Boolean? = false,
        var query: String? = null,
        var beginDateString: String? = null,
        var sortOldest:Boolean = false,
        var arts:Boolean = false,
        var fashion:Boolean = false,
        var style:Boolean = false,
        var sport:Boolean = false

) : Parcelable {
    fun sortOldest(): String? {
        return if (sortOldest) SORT_OLDEST else SORT_NEWEST
    }
    private fun getCurrentDate(): String {
        val date = Date()
        val dateFormat = "dd/MM/yyyy"
        val queryDateFormat = SimpleDateFormat(dateFormat, Locale.US)
        return queryDateFormat.format(date)
    }

    fun update(
            beginDate: Date?,
            oldest: Boolean,
            isArts: Boolean,
            isFashion: Boolean,
            isStyle: Boolean,
            isSport: Boolean
    ) {
        beginDateString = getCurrentDate().format(beginDate)
        ignoreBeginDate = true
        sortOldest = oldest
        arts = isArts
        fashion = isFashion
        style = isStyle
        sport = isSport
    }

    fun update1(
            oldest: Boolean,
            isArts: Boolean,
            isFashion: Boolean,
            isStyle: Boolean,
            isSport: Boolean
    ) {
        ignoreBeginDate = true
        sortOldest = oldest
        arts = isArts
        fashion = isFashion
        style = isStyle
        sport = isSport
    }

    fun searchFilters() {
        query = null
        sortOldest = false
        arts = true.also { sport = it }.also { style = it }.also { fashion = it }

        val calendar = Calendar.getInstance()
        calendar.add(Calendar.WEEK_OF_MONTH, -1)
        beginDateString = getCurrentDate().format(calendar.time)
        ignoreBeginDate = true
    }

    fun setQuery() {
        this.query = query
    }

    fun resetQuery() {
        query = null
    }

    fun getNewsDesk(): String? {
        val newsDesks: MutableList<String> = ArrayList()
        if (arts) newsDesks.add(newsDeskArts)
        if (fashion) newsDesks.add(newsDeskFashion)
        if (style) newsDesks.add(newsDeskStyle)
        if (sport) newsDesks.add(newsDeskSport)
        var builder : StringBuilder ? = null
        var joinedString: String = join(newsDesks, " ")
        if (joinedString.isNotEmpty()) {
            builder?.append("news_desk:(")?.append(joinedString)?.append(")")
        }
        val result = builder.toString()
        return if (result.isEmpty()) null else result
    }

    private fun join(list: List<String>, delim: String): String {
        val sb = java.lang.StringBuilder()
        var loopDelim = ""
        for (s in list) {
            sb.append(loopDelim)
            sb.append(s)
            loopDelim = delim
        }
        Log.e(ContentValues.TAG, sb.toString())
        return sb.toString()

    }

}


