package com.example.testapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val api = RetrofitClient.retrofit.create(UserApis::class.java)
        val callProducts = api.getProducts()
        callProducts.enqueue(object  : Callback<ArrayList<Products>>{
            override fun onResponse(
                call: Call<ArrayList<Products>>,
                response: Response<ArrayList<Products>>
            ) {
                val recycle = findViewById<RecyclerView>(R.id.recycle)
                recycle.adapter = MyAdapter(response.body()!!)
            }

            override fun onFailure(call: Call<ArrayList<Products>>, t: Throwable) {
                Log.d("erro",t.toString())
            }

        })
    }
}