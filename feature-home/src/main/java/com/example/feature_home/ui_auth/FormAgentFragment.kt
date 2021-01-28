package com.example.feature_home.ui_auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.feature_home.R
import com.example.feature_home.databinding.FragmentFormAgentBinding

class FormAgentFragment : Fragment() {

    private lateinit var binding: FragmentFormAgentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_form_agent, container, false)
        val binding = FragmentFormAgentBinding.bind(view)



        return view
    }
}