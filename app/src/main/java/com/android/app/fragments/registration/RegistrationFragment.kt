package com.android.app.fragments.registration

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.android.app.R
import com.android.app.databinding.FragmentRegistrationBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_login.*

@AndroidEntryPoint
class RegistrationFragment : Fragment() {

    private val viewModel: RegistrationViewModel by viewModels()
    private lateinit var binding: FragmentRegistrationBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegistrationBinding.inflate(inflater, container, false)

        binding.signUpButton.setOnClickListener {
            viewModel.register(
                binding.emailEditText.text.toString(),
                binding.fioEditText.text.toString(),
                binding.phoneEditText.text.toString()
            )
            binding.signUpButton.setOnClickListener {
//                if (viewModel.id!=0) == findNavController().navigate(TODO())
            }
        }

        return binding.root
    }
}