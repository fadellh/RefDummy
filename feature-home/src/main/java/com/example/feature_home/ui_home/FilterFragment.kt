package com.example.feature_home.ui_home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.feature_home.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.button.MaterialButton

class FilterFragment : BottomSheetDialogFragment() {

    private val viewModel : HomeViewModel by viewModels()


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?):
            View? {
        val view = inflater.inflate(R.layout.fragment_bottom_sheet,container,false)
        val btnSortName = view.findViewById<MaterialButton>(R.id.btnFilterSortName)

        btnSortName.setOnClickListener {
          Log.d("coba","Mausk")
        }


        return view
    }
}