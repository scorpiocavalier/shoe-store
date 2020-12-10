package com.udacity.shoestore.screens.shoe

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoeListViewModel : ViewModel() {
  // Using MutableLiveData and LiveData
  // for encapsulation and live data observer pattern.
  private val _shoeList = MutableLiveData<MutableList<String>>()
  val shoeList: LiveData<MutableList<String>>
    get() = shoeList

//  init {
//    (_shoeList.value)?.add("Adidas")
//  }
}