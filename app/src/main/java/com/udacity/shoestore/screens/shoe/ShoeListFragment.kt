package com.udacity.shoestore.screens.shoe

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.onNavDestinationSelected
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import kotlinx.android.synthetic.main.shoe_row.view.*

class ShoeListFragment : Fragment() {

  private lateinit var binding: FragmentShoeListBinding
  private val model: ShoeViewModel by activityViewModels()

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    setHasOptionsMenu(true)
    binding = FragmentShoeListBinding.inflate(inflater, container, false)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    // Attach an Observer to viewModel LiveData variables
    model.shoes.observe(viewLifecycleOwner, { shoes ->
      shoes.forEach { shoe ->
        val newView = View.inflate(context, R.layout.shoe_row, null)
        newView.shoeNameTextView.text = shoe.name
        newView.shoeCompanyTextView.text = shoe.company
        newView.shoeSizeTextView.text = shoe.size.toString()
        newView.shoeDescriptionTextView.text = shoe.description
        binding.shoeListLayout.addView(newView)
      }
    })

    // Add an event listener for the plus button
    binding.floatingActionButton.setOnClickListener(
      Navigation.createNavigateOnClickListener(
        ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment()
      )
    )
  }

  // Inflate menu for log out function
  override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
    inflater.inflate(R.menu.overflow_menu, menu)
  }

  // Navigate to login screen when log out item is selected
  override fun onOptionsItemSelected(item: MenuItem): Boolean {
    return item.onNavDestinationSelected(findNavController())
            || super.onOptionsItemSelected(item)
  }
}