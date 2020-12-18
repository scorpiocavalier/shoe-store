package com.udacity.shoestore.screens.shoe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding

class ShoeDetailFragment : Fragment() {

  private lateinit var binding: FragmentShoeDetailBinding
  private val model: ShoeViewModel by activityViewModels()

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

    binding.apply {
      saveButton.setOnClickListener {
        model.addShoe(
          Shoe(
            shoeName!!,
            shoeSize!!.toDouble(),
            shoeCompany!!,
            shoeDescription!!
          )
        )
        findNavController().navigateUp()
      }

      cancelButton.setOnClickListener {
        findNavController().navigateUp()
      }
    }
  }
}