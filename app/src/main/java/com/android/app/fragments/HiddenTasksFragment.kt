package com.android.app.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.android.app.R


class HiddenTasksFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setupToolbar()

        return inflater.inflate(R.layout.fragment_hidden_tasks, container, false)
    }

    fun setupToolbar(){
        val toolbarMain = view?.findViewById<Toolbar>(R.id.toolbar)
        (activity as AppCompatActivity).apply {
            setSupportActionBar(toolbarMain)
            toolbarMain?.inflateMenu(R.menu.toolbar_menu)
        }
    }
}