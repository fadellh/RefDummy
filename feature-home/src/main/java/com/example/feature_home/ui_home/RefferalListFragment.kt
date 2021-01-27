package com.example.feature_home.ui_home

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.feature_home.R
import com.example.feature_home.data.api.request.RefferalListRequest
import com.example.feature_home.data.domain.RefferalList
import com.example.feature_home.data.persistance.entity.toDomain
import com.google.android.material.button.MaterialButton
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RefferalListFragment: Fragment(R.layout.fragment_refferal_list){

    private val viewModel : HomeViewModel by viewModels()
    //private lateinit var holder : HomeViewHolder()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val btnFilter = view.findViewById<MaterialButton>(R.id.btnFilter)
        val rvHome = view.findViewById<RecyclerView>(R.id.rvRefList)
        val etName = view.findViewById<EditText>(R.id.etPatientName)
        val btnAdd = view.findViewById<MaterialButton>(R.id.btnConfirm)
        val btnSortName = view.findViewById<MaterialButton>(R.id.btnSortName)
       // val

        val adapter = HomeViewHolder()
        rvHome.layoutManager = LinearLayoutManager(requireContext())
        rvHome.adapter = adapter

        viewModel.readAllDataAsFlow.observe(viewLifecycleOwner, Observer<List<RefferalList>> { res ->
            adapter.setData(res)
        })

        // viewModel.getRoomData()
        //viewModel.getDataReferral()
        viewModel.refResponse.observe(viewLifecycleOwner, Observer { response ->
            if(response.isSuccessful){
                val result = response.body()!!
                val adapter = HomeViewHolder()
                rvHome.layoutManager = LinearLayoutManager(context)
                rvHome.adapter = adapter
                adapter.setData(result)
            }else{
                Log.d("coba2","aggal")
            }
        })



        btnAdd.setOnClickListener {
            val checkName = etName.text.toString()
            if(checkName != ""){
               // val ref = com.example.feature_home.data.persistance.entity.RefferalList(id=0, patientName = checkName,status = 0)
                val request = RefferalListRequest(patientName = checkName)
                viewModel.createPatient(request)
               // viewModel.addDataPatient(ref)
            }else{
                Log.d("coba","Slaah")
            }
        }

        btnFilter.setOnClickListener {
            //findNavController().navigate(R.id.action_refferalListFragment_to_filterFragment)
            viewModel.setFilterOrSort(false, filter = true)
        }

        btnSortName.setOnClickListener {
            viewModel.setFilterOrSort(true, filter = false)
        }



    }





}