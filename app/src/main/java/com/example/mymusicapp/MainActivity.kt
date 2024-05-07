package com.example.mymusicapp

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        val retrofitBuilder = Retrofit.Builder()
            .baseUrl("https://deezerdevs-deezer.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)
        val retrofitData= retrofitBuilder.getData("eminem")


        retrofitData.enqueue(object : Callback<MyData> {
            override fun onResponse(p0: Call<MyData?>, p1: Response<MyData?>) {
                val datalist= p1.body()
                val textView= findViewById<TextView>(R.id.hellotext)
                textView.text= datalist.toString()
                Log.d("TAG: onResponse", "onResponse: " + p1.body())
            }

            override fun onFailure(p0: Call<MyData>, p1: Throwable) {
                Log.d("TAG: onFailure" , "onFailure" + p1.message)
            }


        })
    }

}
