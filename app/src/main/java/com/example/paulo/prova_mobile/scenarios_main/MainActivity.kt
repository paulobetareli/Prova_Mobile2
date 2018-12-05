package com.example.paulo.prova_mobile.scenarios_main

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.ProgressBar
import android.widget.Toast
import com.example.paulo.prova_mobile.R
import com.example.paulo.prova_mobile.entities.Drink
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainContract.View,DrinksListFragment.onfragmentInteractionListener {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       // editText.onKeyUp()

        val presenter : MainContract.Presenter = MainPresenter(this)
        presenter.onLoadList()

    }

    override fun ListDescription(drink: Drink) {
        val fragmentDetailList = DrinksDescriptionFragment.newInstance(drink)
        supportFragmentManager.beginTransaction()
            .replace(R.id.fmMaster,fragmentDetailList)
            .commit()
    }

    override fun ShowList(drinks: List<Drink>) {

        val fragmentDrinksList = DrinksListFragment.newInstance(drinks as ArrayList<Drink>)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fmMaster,fragmentDrinksList)
            .commit()


    }

    override fun onfragmentInteraction(drink: Drink) {

        val fragmentDescription = DrinksDescriptionFragment.newInstance(drink)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fmMaster,fragmentDescription)
            .commit()
    }


    override fun showMessage(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }

    override fun hideLoading() {
        pbLoading.visibility = ProgressBar.INVISIBLE
    }

    override fun showLoading() {
        pbLoading.visibility = ProgressBar.VISIBLE
    }



}
