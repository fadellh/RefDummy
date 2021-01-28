package com.example.feature_home.ui_auth

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.feature_home.R
import com.example.feature_home.databinding.FragmentAuthMainBinding


class WelcomeAuthFragment : Fragment(R.layout.fragment_auth_main) {

    private lateinit var binding: FragmentAuthMainBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentAuthMainBinding.bind(view)

        binding.btnLogin.setOnClickListener {
            findNavController().navigate(R.id.action_welcomeAuthFragment_to_homeActivity)
        }

        binding.tvRegister.setOnClickListener {
            findNavController().navigate(R.id.action_welcomeAuthFragment_to_registerFragment)
        }
    }

}