package com.example.paulo.prova_mobile.scenarios_main

import com.example.paulo.prova_mobile.entities.DrinkList
import com.example.paulo.prova_mobile.network.RetrofitInicializer
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainPresenter(val view : MainContract.View) : MainContract.Presenter {
    override fun onLoadList(){

        view.showLoading()

        val drinksService = RetrofitInicializer().createDrinksService()

        val call =  drinksService.getAllDrinksAlcoholic()

        call.enqueue(object : Callback<DrinkList> {
            override fun onFailure(call: Call<DrinkList>, t: Throwable) {
                view.hideLoading()
                view.showMessage("FALHA NA CONEXÃO")
            }

            override fun onResponse(call: Call<DrinkList>, response: Response<DrinkList>) {
                view.hideLoading()
                if(response.body() != null){
                    view.ShowList(response.body()!!.drinks)
                }else{
                    view.showMessage("NENHUM DRINK RETORNADO")
                }
            }
        })

       // val callDrinkDescription = drinksService.getDrinksDetailsById("idDrink")
    }
}