package com.udacity.shoestore.screens.shoe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import timber.log.Timber

class ShoeDetailFragment : Fragment() {

  private lateinit var binding: FragmentShoeDetailBinding

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_detail, container, false)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    binding.saveButton.setOnClickListener {
      Timber.i(binding.shoeName)
      Timber.i(binding.shoeCompany)
      Timber.i(binding.shoeSize)
      Timber.i(binding.shoeDescription)
      findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment())
    }

    binding.cancelButton.setOnClickListener(
      Navigation.createNavigateOnClickListener(
        ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment()
      )
    )
  }
}