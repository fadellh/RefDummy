package com.example.feature_home.ui_home

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.feature_home.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SummaryFragment : Fragment(R.layout.fragment_refferal_summary) {

    private val viewModel : HomeViewModel by viewModels()

}