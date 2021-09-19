package com.example.boredactivity

import com.example.boredactivity.Model.FakePostModel
import com.example.boredactivity.Model.FakePostModelItem
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface ApiClient {
//    @GET("/activity")
//    fun getBoredActivity() : Response<BoredModel>

    @GET("/comments")
   suspend fun getBoredActivity() : Response<List<FakePostModelItem>>
}