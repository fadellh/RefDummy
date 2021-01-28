package com.example.feature_home.ui_auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.feature_home.R
import com.example.feature_home.databinding.FragmentRegisterBinding
import kotlinx.android.synthetic.main.fragment_register.*

class RegisterFragment : Fragment() {

    private lateinit var binding: FragmentRegisterBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_register, container, false)
        val binding = FragmentRegisterBinding.bind(view)

        binding.btnDoctor.setOnClickListener {
            val isDoctor = true
            val actionArg = RegisterFragmentDirections.actionRegisterFragmentToFormDoctorFragment(isDoctor)
            findNavController().navigate(actionArg)
        }
        binding.btnBidan.setOnClickListener {
            findNavController().navigate(R.id.action_registerFragment_to_formDoctorFragment)
        }
        binding.btnAgent.setOnClickListener {
            findNavController().navigate(R.id.action_registerFragment_to_formSharp)
        }





        return view
    }

}