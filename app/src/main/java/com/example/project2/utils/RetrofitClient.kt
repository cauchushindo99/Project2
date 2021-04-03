package com.example.project2.utils

import com.example.project2.api.ApiService
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
const val API_KEY = "gvnV6vhygnxgy79Fz2iPCmJFRQsx0emw"
const val BASE_URL = "https://api.nytimes.com/svc/search/v2/"

class RetrofitClient {
    companion object{
        var retrofit: Retrofit? = null

        fun getClient(): Retrofit? {
            if( retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build()
            }
            return retrofit
        }
        fun getBuilder(): OkHttpClient? {
            return OkHttpClient.Builder()
                .addNetworkInterceptor { chain: Interceptor.Chain ->
                    var request: Request = chain.request()
                    val url: HttpUrl = request.url()
                        .newBuilder()
                        .addQueryParameter("api_key", API_KEY)
                        .build()
                    request = request.newBuilder()
                        .url(url)
                        .build()
                    chain.proceed(request)
                }
                .build()
        }
        fun getService(
            page: Any?,
            ignoreBeginDate: Any?,
            beginDateString: String?,
            newsDesk: String?
        ): ApiService? {
            return getClient()?.create(ApiService::class.java)
        }

    }
}