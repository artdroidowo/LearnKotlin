package com.example.karol.learnkotlin

import com.example.karol.learnkotlin.model.SearchedRecords
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface WikiApiService {

    @GET("api.php")
    fun getRecordsByQuerry(@Query("action") action: String,
                           @Query("format") format: String,
                           @Query("list") list: String,
                           @Query("srsearch") srsearch: String): Observable<SearchedRecords>

    @GET("api.php")
    fun getMoreRecords(@Query("action") action: String,
                       @Query("format") format: String,
                       @Query("list") list: String,
                       @Query("continue") _continue: String,
                       @Query("sroffset") sroffset: Int,
                       @Query("srsearch") srsearch: String): Observable<SearchedRecords>

    companion object {
        fun create(): WikiApiService {
            return Retrofit.Builder()
                    .addCallAdapterFactory(
                            RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("https://pl.wikipedia.org/w/")
                    .build()
                    .create(WikiApiService::class.java)
        }
    }
}