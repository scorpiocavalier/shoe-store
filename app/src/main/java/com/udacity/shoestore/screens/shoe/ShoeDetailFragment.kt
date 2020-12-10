package com.udacity.shoestore.screens.shoe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.udacity.shoestore.R
import kotlinx.android.synthetic.main.fragment_shoe_detail.*

class ShoeDetailFragment : Fragment() {

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    return inflater.inflate(R.layout.fragment_shoe_detail, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    // Create a new Shoe with the form data
    val name = "Adidas Ultraboost"
    val shoeSize = 10.0
    val company = "Adidas"
    val description = "Most comfortable shoes ever created."
    var newShoe = Shoe(name, shoeSize, company, description)

    save_button.setOnClickListener(
      Navigation.createNavigateOnClickListener(
        ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment()
      )
    )

    cancel_button.setOnClickListener(
      Navigation.createNavigateOnClickListener(
        ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment()
      )
    )
  }
}