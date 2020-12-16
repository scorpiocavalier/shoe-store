package com.udacity.shoestore.screens.shoe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.SharedViewModel
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.screens.shoe.model.Shoe

class ShoeDetailFragment : Fragment() {

  private lateinit var binding: FragmentShoeDetailBinding
  private lateinit var viewModel: SharedViewModel

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {

    binding = FragmentShoeDetailBinding.inflate(inflater, container, false)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    viewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)

    binding.saveButton.setOnClickListener {
      viewModel.addShoe(
        Shoe(
          binding.shoeName!!,
          binding.shoeSize!!.toDouble(),
          binding.shoeCompany!!,
          binding.shoeDescription!!
        )
      )
      findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment())
    }

    binding.cancelButton.setOnClickListener(
      Navigation.createNavigateOnClickListener(
        ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment()
      )
    )
  }
}