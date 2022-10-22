package com.android.app.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.android.app.R
import com.android.app.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)


        if (1 > 2){
            findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
        }



        binding.nextTextView.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registrationFragment)
        }

        return binding.root
    }

    fun setupToolbar(){
        val toolbarMain = view?.findViewById<Toolbar>(R.id.toolbar)
        (activity as AppCompatActivity).apply {
            setSupportActionBar(toolbarMain)
            toolbarMain?.inflateMenu(R.menu.toolbar_menu)
        }
    }
}