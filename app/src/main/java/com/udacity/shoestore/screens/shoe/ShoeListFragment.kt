package com.udacity.shoestore.screens.shoe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.udacity.shoestore.R
import kotlinx.android.synthetic.main.fragment_shoe_list.*

class ShoeListFragment : Fragment() {

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    return inflater.inflate(R.layout.fragment_shoe_list, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    floatingActionButton.setOnClickListener(
      Navigation.createNavigateOnClickListener(
        ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment()
      )
    )
  }
}