package com.example.boredactivity

//import retrofit.RxJavaCallAdapterFactory
import retrofit2.CallAdapter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
//    private const val  BASE_URL= "https://www.boredapi.com/api/"
    private const val  BASE_URL= "https://jsonplaceholder.typicode.com/posts/1/"

    fun getRetrofitInstance(): Retrofit? {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)

            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}