package com.example.boredactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
     lateinit var textview:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
            textview =findViewById(R.id.tv)
        val boredApi = RetrofitHelper.getRetrofitInstance()?.create(ApiClient::class.java)
//        val result = boredApi?.getBoredActivity()

        //old

//        if (result != null) {
////            textview.text =  result.execute().body().toString()
//            Log.d("rawat", "onCreate: Works"+result.enqueue(object : Callback<List<FakePostModelItem>>{
//                override fun onResponse(
//                    call: Call<List<FakePostModelItem>>?,
//                    response: Response<List<FakePostModelItem>>?
//                ) {
//                    var dataList :List<FakePostModelItem> = response!!.body()
//                    Log.d("rawat", "onResponse: "+dataList)
//                    textview.text = dataList.toString()
//                }
//
//                override fun onFailure(call: Call<List<FakePostModelItem>>?, t: Throwable?) {
//                    Log.d("rawat", "onFailure: "+ t!!.message)
//                }
//
//            }))
//        }

        //new
        GlobalScope.launch (Dispatchers.IO){
            val result = boredApi?.getBoredActivity()
            if(result!!.isSuccessful ) {
                Log.d("rawat", "onCreate: " + result.body())
                textview.text = result.body().toString()
            }
        }
    }
}