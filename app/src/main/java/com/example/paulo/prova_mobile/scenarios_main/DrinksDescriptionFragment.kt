package com.example.paulo.prova_mobile.scenarios_main


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.paulo.prova_mobile.R
import com.example.paulo.prova_mobile.entities.Drink
import com.example.paulo.prova_mobile.utils.GlideApp
import kotlinx.android.synthetic.main.fragment_drinks_description.*
import java.lang.NullPointerException


/**
 * A simple [Fragment] subclass.
 *
 */
class DrinksDescriptionFragment : Fragment() {

    companion object {
        private val ARG_DRINK = "arg_drink"

        fun newInstance(drink: Drink) =
            DrinksDescriptionFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(ARG_DRINK, drink)
                }
            }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_drinks_description, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val drink = getDrink()

        activity?.let{
            GlideApp.with(it)
                .load(drink.strDrinkThumb)
                .placeholder(R.drawable.no_image)
                .centerCrop()
                .into(imgDrink)
        }

        txName.text = drink.strDrink;
        txCategory.text = drink.strCategory;
        txId_value_drink.text = drink.idDrink.toString();
        txalcoholic.text = drink.strAlcoholic;
        txIngre_1.text = drink.strIngredient1;
        txIngre_2.text = drink.strIngredient2;
        txIngre_3.text = drink.strIngredient3;
        txIngre_4.text = drink.strIngredient4;
        txInstruction.text = drink.strInstructions;


    }

    fun getDrink(): Drink{
        val drinks = arguments?.getSerializable(ARG_DRINK) as Drink

        if(drinks != null){
            return drinks
        }else {
            throw NullPointerException("Bebida não pode ser nula")
        }
    }


}
