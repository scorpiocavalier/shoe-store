package com.udacity.shoestore.screens.shoe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.udacity.shoestore.R
import com.udacity.shoestore.SharedViewModel
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.screens.shoe.model.Shoe
import kotlinx.android.synthetic.main.shoe_row.view.*

class ShoeListFragment : Fragment() {

  private lateinit var binding: FragmentShoeListBinding
  private lateinit var viewModel: SharedViewModel

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {

    binding = FragmentShoeListBinding.inflate(inflater, container, false)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    // Always use a ViewModelProvider to instantiate a ViewModel
    viewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)

    // Attach an Observer to viewModel LiveData variables
    viewModel.shoes.observe(viewLifecycleOwner, Observer<MutableList<Shoe>> { shoes ->
      for (shoe in shoes) {
        var newView = View.inflate(context, R.layout.shoe_row, null)
        newView.shoeNameTextView.text = shoe.name
        newView.shoeCompanyTextView.text = shoe.company
        newView.shoeSizeTextView.text = shoe.size.toString()
        newView.shoeDescriptionTextView.text = shoe.description
        binding.shoeListLayout.addView(newView)
      }
    })

    binding.floatingActionButton.setOnClickListener(
      Navigation.createNavigateOnClickListener(
        ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment()
      )
    )
  }
}