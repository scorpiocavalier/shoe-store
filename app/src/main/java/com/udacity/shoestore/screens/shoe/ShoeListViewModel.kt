package com.udacity.shoestore.screens.shoe

import androidx.lifecycle.ViewModel

class ShoeListViewModel : ViewModel() {
//  // Using MutableLiveData and LiveData
//  // for encapsulation and live data observer pattern.
//  private val _shoes = MutableLiveData<MutableList<Shoe>>()
//  val shoes: LiveData<MutableList<Shoe>> = _shoes
//
//  init {
//    (_shoes.value)?.add(Shoe(
//      "Adidas Ultraboost",
//      10.0,
//      "Adidas",
//      "Most comfortable shoes ever created."))
//  }
//
//  fun addShoe(shoe: Shoe): LiveData<MutableList<Shoe>> {
//    (_shoes.value)?.add(shoe)
//    return _shoes
//  }
}