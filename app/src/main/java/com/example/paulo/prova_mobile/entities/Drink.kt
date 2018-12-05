package com.example.paulo.prova_mobile.entities

import java.io.Serializable

data class Drink (val strDrink: String,
                  val strDrinkThumb: String,
                  val strAlcoholic: String,
                  val strCategory: String,
                  val strInstructions: String,
                  val strIngredient1: String,
                  val strIngredient2: String,
                  val strIngredient3: String,
                  val strIngredient4: String,
                  val idDrink: Int) : Serializable