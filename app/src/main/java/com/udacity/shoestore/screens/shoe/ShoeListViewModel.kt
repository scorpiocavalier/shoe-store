package com.udacity.shoestore.screens.shoe

import androidx.lifecycle.ViewModel

class ShoeListViewModel : ViewModel() {
  val shoeList = mutableListOf<Shoe>()
}