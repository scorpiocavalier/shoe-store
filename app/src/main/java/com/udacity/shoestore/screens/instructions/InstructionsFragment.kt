package com.udacity.shoestore.screens.instructions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentInstructionsBinding

class InstructionsFragment : Fragment() {

  private lateinit var binding: FragmentInstructionsBinding
  private val instruction1 = "1. Add your items"
  private val instruction2 = "2. View your items"
  private val buttonText = "View shoe list"

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {

    binding = DataBindingUtil.inflate(inflater, R.layout.fragment_instructions, container, false)
    binding.instruction1 = instruction1
    binding.instruction2 = instruction2
    binding.buttonText = buttonText

    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    binding.shoeListButton.setOnClickListener(
      Navigation.createNavigateOnClickListener(
        InstructionsFragmentDirections.actionInstructionsFragmentToShoeListFragment()
      )
    )
  }
}