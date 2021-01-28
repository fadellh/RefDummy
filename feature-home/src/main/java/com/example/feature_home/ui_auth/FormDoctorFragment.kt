package com.example.feature_home.ui_auth

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.feature_home.R
import com.example.feature_home.databinding.FragmentFormDoctorBinding

class FormDoctorFragment : Fragment() {

    private lateinit var binding: FragmentFormDoctorBinding
    private val args by navArgs<FormDoctorFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_form_doctor, container, false)
        val binding = FragmentFormDoctorBinding.bind(view)

        when(args.isDoctor){
            true -> binding.btnSpeciality.visibility = View.VISIBLE
            false -> binding.btnSpeciality.visibility = View.GONE
        }

        binding.tvContinue.setOnClickListener {
            findNavController().navigate(R.id.action_formDoctorFragment_to_formSharp)
        }


        return view
    }

}