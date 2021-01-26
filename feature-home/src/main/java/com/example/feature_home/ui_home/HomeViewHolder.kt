package com.example.feature_home.ui_home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.feature_home.R
import com.example.feature_home.data.api.response.RefferalListResponse
import com.example.feature_home.data.domain.RefferalList
import com.google.android.material.textview.MaterialTextView

class HomeViewHolder(

) : RecyclerView.Adapter<HomeViewHolder.ListHolder>() {

    private var dataList = emptyList<RefferalList>()
    inner class ListHolder (itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_referral_list, parent, false)
        return ListHolder(view)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ListHolder, position: Int) {

        holder.itemView.apply {
            val tvStatus = this.findViewById<MaterialTextView>(R.id.tvStatus)
            val tvPatientName = this.findViewById<MaterialTextView>(R.id.tvPatientName)
            val checkPatient = dataList!![position].patient_name

            if(checkPatient == null){
                tvPatientName.text = "isNull"
                tvStatus.text = "0"
            }else{
                tvStatus.text = dataList!![position].status.toString()
                tvPatientName.text = dataList!![position].patient_name
            }
        }
    }

    fun setData(list : List<RefferalList>){
        this.dataList = list
        notifyDataSetChanged()
    }

}