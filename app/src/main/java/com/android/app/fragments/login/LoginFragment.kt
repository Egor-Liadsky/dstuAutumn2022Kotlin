package com.android.app.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.android.app.R
import com.android.app.databinding.FragmentLoginBinding
import com.android.app.fragments.login.LoginViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private val viewModel: LoginViewModel by viewModels()
    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)

        val phone = binding.phoneEditText.text.toString()
        val email = binding.emailEditText.text.toString()

        binding.signInButton.setOnClickListener {
            if (phone.isNotEmpty() && email.isNotEmpty()){
                viewModel.login(phone = phone, email = email)
//                if (viewModel.id != 0) {
//                    TODO()
//                }
            } else {
                Snackbar.make(
                    binding.loginFragment, "Некоректные данные", Snackbar.LENGTH_SHORT
                ).show()
            }

        }

        binding.nextTextView.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registrationFragment)
        }

        binding.signInButton.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_tasksFragment)
        }

        return binding.root
    }

}