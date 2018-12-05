package com.example.paulo.prova_mobile.scenarios_main


import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter

import com.example.paulo.prova_mobile.R
import com.example.paulo.prova_mobile.entities.Drink
import kotlinx.android.synthetic.main.fragment_drinks_list.*
import java.lang.NullPointerException
import java.lang.RuntimeException


/**
 * A simple [Fragment] subclass.
 *
 */
class DrinksListFragment : Fragment() {

    companion object {
        private val ARG_LIST = "arg_list"

        fun newInstance(list: ArrayList<Drink>) =
            DrinksListFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(ARG_LIST, list)
                }
            }
        }

    var listener: onfragmentInteractionListener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_drinks_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val drinks = getDrinksList()

        activity?.let{
            val adapter = DrinkAdapter(it, drinks)
            adapter.setOnItemClickListener {position ->
                listener?.onfragmentInteraction(drinks[position])
            }

            rvNews.adapter = adapter
            rvNews.layoutManager = LinearLayoutManager(it)

        }


    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)


        if(context is DrinksListFragment.onfragmentInteractionListener){
            listener = context
        }else{
            throw RuntimeException(context.toString() + "deve implementar DrinksListFragment.onfragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    fun getDrinksList(): ArrayList<Drink>{
        val drinks = arguments?.getSerializable(ARG_LIST) as ArrayList<Drink>
        if(drinks != null){
            return drinks
        }else {
            throw NullPointerException("Lista de bebidas não pode ser nula")
        }
    }

    interface onfragmentInteractionListener{
        fun onfragmentInteraction(drink: Drink)
    }

}
