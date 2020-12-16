package com.udacity.shoestore.screens.welcome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.udacity.shoestore.databinding.FragmentWelcomeBinding

class WelcomeFragment : Fragment() {

  private lateinit var binding: FragmentWelcomeBinding
  private val welcomeText = "Welcome to the ShoeStore"
  private val instructionsText = "Read the instructions on how to use the app"
  private val buttonText = "Instructions"

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {

    binding = FragmentWelcomeBinding.inflate(inflater, container, false)
    binding.welcomeText = welcomeText
    binding.instructionsText = instructionsText
    binding.buttonText = buttonText

    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    binding.instructionsButton.setOnClickListener(
      Navigation.createNavigateOnClickListener(
        WelcomeFragmentDirections.actionWelcomeFragmentToInstructionsFragment()
      )
    )
  }
}