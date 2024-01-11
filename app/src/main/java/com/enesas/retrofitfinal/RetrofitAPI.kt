package com.enesas.retrofitfinal

import retrofit2.Call
import retrofit2.http.GET

interface RetrofitAPI {

    @GET("atilsamancioglu/BTK20-JSONVeriSeti/master/besinler.json")
    fun getBesin() : Call<List<Besin>>

}