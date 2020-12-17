package com.udacity.shoestore.screens.login.ui

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

  private lateinit var loginViewModel: LoginViewModel
  private lateinit var binding: FragmentLoginBinding

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    binding = FragmentLoginBinding.inflate(inflater, container, false)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    loginViewModel = ViewModelProvider(this, LoginViewModelFactory())
      .get(LoginViewModel::class.java)

    loginViewModel.loginFormState.observe(viewLifecycleOwner,
      Observer { loginFormState ->
        if (loginFormState == null) {
          return@Observer
        }

        binding.apply {
          registerButton.isEnabled = loginFormState.isDataValid
          loginButton.isEnabled = loginFormState.isDataValid
          loginFormState.usernameError?.let {
            usernameField
          }
          loginFormState.passwordError?.let {
            passwordField.error = getString(it)
          }
        }
      })

    loginViewModel.loginResult.observe(viewLifecycleOwner,
      Observer { loginResult ->
        loginResult ?: return@Observer

        binding.loading.visibility = View.GONE
        loginResult.error?.let {
          showLoginFailed(it)
        }
        loginResult.success?.let {
          updateUiWithUser(it)
          // Hide Keyboard on successful login
          val imm =
            view.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
          imm.hideSoftInputFromWindow(view.windowToken, 0)
          // Navigate user to Welcome Screen
          view.findNavController().navigate(
            LoginFragmentDirections.actionLoginFragmentToWelcomeFragment()
          )
        }
      })

    val afterTextChangedListener = object : TextWatcher {
      override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
        // ignore
      }

      override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
        // ignore
      }

      override fun afterTextChanged(s: Editable) {
        loginViewModel.loginDataChanged(
          binding.usernameField.text.toString(),
          binding.passwordField.text.toString()
        )
      }
    }

    binding.apply {
      usernameField.addTextChangedListener(afterTextChangedListener)
      passwordField.addTextChangedListener(afterTextChangedListener)
      passwordField.setOnEditorActionListener { _, actionId, _ ->
        if (actionId == EditorInfo.IME_ACTION_DONE) {
          loginViewModel.login(
            usernameField.text.toString(),
            passwordField.text.toString()
          )
        }
        false
      }

      registerButton.setOnClickListener {
        loading.visibility = View.VISIBLE
        loginViewModel.login(
          usernameField.text.toString(),
          passwordField.text.toString()
        )
      }

      loginButton.setOnClickListener {
        loading.visibility = View.VISIBLE
        loginViewModel.login(
          usernameField.text.toString(),
          passwordField.text.toString()
        )
      }
    }
  }

  private fun updateUiWithUser(model: LoggedInUserView) {
    val welcome = "${getString(R.string.welcome)}, ${model.displayName}!"
    val appContext = context?.applicationContext ?: return
    Toast.makeText(appContext, welcome, Toast.LENGTH_LONG).show()
  }

  private fun showLoginFailed(@StringRes errorString: Int) {
    val appContext = context?.applicationContext ?: return
    Toast.makeText(appContext, errorString, Toast.LENGTH_LONG).show()
  }
}