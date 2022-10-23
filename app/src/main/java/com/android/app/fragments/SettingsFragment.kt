package com.android.app.fragments

import android.content.res.Configuration
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import com.android.app.Constants
import com.android.app.R
import com.android.app.databinding.FragmentAddNoteBinding
import com.android.app.databinding.FragmentSettingsBinding


class SettingsFragment : Fragment() {
    private lateinit var binding: FragmentSettingsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSettingsBinding.inflate(inflater, container, false)


        binding.changeThemeButton.setOnClickListener {
//            if (Constants.THEME == "light"){
//                binding.changeThemeButton.text = "ТЕМНАЯ"
//            } else {
//                binding.changeThemeButton.text = "СВЕТЛАЯ"
//
//            }
            when(resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK) {
                Configuration.UI_MODE_NIGHT_YES -> {
                    Constants.THEME = "ТЕМНАЯ"
                    binding.changeThemeButton.text = Constants.THEME
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

                }
                Configuration.UI_MODE_NIGHT_NO -> {
                    Constants.THEME = "СВЕТЛАЯ"
                    binding.changeThemeButton.text = Constants.THEME
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                }
            }
        }

        return binding.root
    }
}