package com.example.paulo.prova_mobile.scenarios_main

import com.example.paulo.prova_mobile.entities.Drink

interface MainContract {
    interface View{
        fun showMessage(msg: String)
        fun ShowList(drinks: List<Drink>)
        fun hideLoading()
        fun showLoading()
        fun ListDescription(drink: Drink)

    }

    interface Presenter{
        fun onLoadList()
        fun onClickDrink(drinks: Drink )
    }

}