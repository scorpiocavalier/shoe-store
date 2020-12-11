package com.udacity.shoestore.screens.shoe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding

class ShoeDetailFragment : Fragment() {

  private lateinit var binding: FragmentShoeDetailBinding
  private val titleLabel = "Shoe Details"
  private val shoeNameLabel = "Name"
  private val shoeCompanyLabel = "Company"
  private val shoeSizeLabel = "Size"
  private val shoeDescriptionLabel = "Description"
  private val cancelBtn = "Cancel"
  private val saveBtn = "Save"

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

//    binding.apply {
//      titleLabel = titleLabel
//      shoeNameLabel = shoeNameLabel
//      shoeCompanyLabel = shoeCompanyLabel
//      shoeSizeLabel = shoeSizeLabel
//      shoeDescriptionLabel = shoeDescriptionLabel
//      cancelBtn = cancelBtn
//      saveBtn = saveBtn
//
//      // UI is refreshed with the value in the updated binding object
////      invalidateAll()
//
//      saveButton.setOnClickListener(
//        Navigation.createNavigateOnClickListener(
//          ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment()
//        )
//      )
//
//      cancelButton.setOnClickListener(
//        Navigation.createNavigateOnClickListener(
//          ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment()
//        )
//      )
//    }

    binding.titleLabel = titleLabel
    binding.shoeNameLabel = shoeNameLabel
    binding.shoeCompanyLabel = shoeCompanyLabel
    binding.shoeSizeLabel = shoeSizeLabel
    binding.shoeDescriptionLabel = shoeDescriptionLabel
    binding.cancelBtn = cancelBtn
    binding.saveBtn = saveBtn

    binding.saveButton.setOnClickListener(
      Navigation.createNavigateOnClickListener(
        ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment()
      )
    )

    binding.cancelButton.setOnClickListener(
      Navigation.createNavigateOnClickListener(
        ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment()
      )
    )
  }
}