package com.enesas.retrofitfinal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.enesas.retrofitfinal.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val retrofitApiServis = RetrofitAPIServis

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        var view = binding.root
        setContentView(view)

        val getData = retrofitApiServis.getData()
        getData.enqueue(object : Callback<List<Besin>>{
            override fun onResponse(call: Call<List<Besin>>, response: Response<List<Besin>>) {
                if (response.isSuccessful){
                    response.body()?.let {
                        it.forEach { besin ->
                            println(besin)
                            println(besin.karbonhidrat)
                        }
                    }
                }
            }

            override fun onFailure(call: Call<List<Besin>>, t: Throwable) {
                //Buraya hata mesajı yazılır.
                t.printStackTrace()
            }

        })

    }
}