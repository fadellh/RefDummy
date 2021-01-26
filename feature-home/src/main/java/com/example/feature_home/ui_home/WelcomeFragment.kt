package com.example.feature_home.ui_home

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.feature_home.R
import kotlinx.android.synthetic.main.activity_main.*

class WelcomeFragment : Fragment(R.layout.fragment_welcome_home) {


    private val viewModel : HomeViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tvContinue = view.findViewById<TextView>(R.id.tvContinue)

        tvContinue.setOnClickListener {
            findNavController().navigate(R.id.action_welcomeFragment_to_refferalListFragment)
        }

    }


}