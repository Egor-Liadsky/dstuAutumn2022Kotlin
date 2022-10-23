package com.android.app.fragments

import android.content.res.Configuration
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.viewModels
import com.android.app.Constants
import com.android.app.R
import com.android.app.data.preferences.PreferencesStore
import com.android.app.databinding.FragmentAddNoteBinding
import com.android.app.databinding.FragmentSettingsBinding
import com.android.app.fragments.tasks.SelectUserTaskFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SettingsFragment : Fragment() {

    private lateinit var binding: FragmentSettingsBinding
    private val viewModel: SelectUserTaskFragmentViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSettingsBinding.inflate(inflater, container, false)
        binding.changeThemeButton.text = Constants.THEME
        binding.changeThemeButton.setOnClickListener {
//            if (Constants.THEME == "light"){
//                binding.changeThemeButton.text = "ТЕМНАЯ"
//            } else {
//                binding.changeThemeButton.text = "СВЕТЛАЯ"
//
//            }
            when(resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK) {
                Configuration.UI_MODE_NIGHT_YES -> {
                    Constants.THEME = "ЗЕЛЕНАЯ"
//                    binding.changeThemeButton.text = Constants.THEME
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                    viewModel.preferencesStore.saveTheme(true)
                }
                Configuration.UI_MODE_NIGHT_NO -> {
                    Constants.THEME = "СИНЯЯ"
//                    binding.changeThemeButton.text = Constants.THEME
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                    viewModel.preferencesStore.saveTheme(false)
                }
            }
        }

        return binding.root
    }
}