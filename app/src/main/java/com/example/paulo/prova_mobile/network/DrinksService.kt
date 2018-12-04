package com.example.paulo.prova_mobile.network

import com.example.paulo.prova_mobile.entities.DrinkList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface DrinksService {

    companion object {
        private const val API_KEY = 1;
    }

    @GET("${API_KEY}/filter.php?a=Alcoholic")
    fun getAllDrinksAlcoholic(): Call<DrinkList>

    @GET("${API_KEY}/lookup.php?i=")
    fun getDrinksDetailsById(@Query("idDrink") id: Int): Call<DrinkList>
}