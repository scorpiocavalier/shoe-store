package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.screens.shoe.model.Shoe

class SharedViewModel : ViewModel() {

  private val _shoes = MutableLiveData<MutableList<Shoe>>()
  val shoes: LiveData<MutableList<Shoe>> = _shoes

  init {
    _shoes.value = mutableListOf<Shoe>()
    addShoe(
      Shoe(
        "Adidas Ultraboost",
        10.0,
        "Adidas",
        "Most comfortable shoes ever created."
      )
    )
    addShoe(
      Shoe(
        "Adidas Ultraboost 2",
        10.5,
        "Adidas",
        "Most comfortable shoes ever created."
      )
    )
    addShoe(
      Shoe(
        "Adidas Ultraboost 3",
        9.5,
        "Adidas",
        "Most comfortable shoes ever created."
      )
    )
  }

  fun addShoe(shoe: Shoe): LiveData<MutableList<Shoe>> {
    (_shoes.value)?.add(shoe)
    return _shoes
  }
}