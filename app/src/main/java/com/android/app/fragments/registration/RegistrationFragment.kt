package com.android.app.fragments.registration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.android.app.R
import com.android.app.databinding.FragmentRegistrationBinding
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegistrationFragment : Fragment() {

    private val viewModel: RegistrationViewModel by viewModels()
    private lateinit var binding: FragmentRegistrationBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegistrationBinding.inflate(inflater, container, false)

        val email = binding.emailEditText.text.toString()
        val name = binding.fioEditText.text.toString()
        val phone = binding.phoneEditText.text.toString()

        binding.signUpButton.setOnClickListener {
            if (binding.emailEditText.text.isEmpty() || binding.fioEditText.text.isEmpty() || binding.phoneEditText.text.isEmpty()) {
                Snackbar.make(
                    binding.regFragment, "Некоректные данные", Snackbar.LENGTH_SHORT
                ).show()
            } else {
                viewModel.register(name = name, email = email, phone = phone)
                findNavController().navigate(R.id.action_registrationFragment_to_tasksFragment)
            }
        }

        return binding.root
    }
}