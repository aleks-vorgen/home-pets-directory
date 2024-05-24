package com.example.odz.database

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.odz.R

class PetAdapter(listMain: ArrayList<String>) : RecyclerView.Adapter<PetAdapter.PetHolder>() {
    private var listArray = listMain

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PetHolder {
        val inflater = LayoutInflater.from(parent.context)
        return PetHolder(inflater.inflate(R.layout.recycler_view_item, parent, false))
    }

    override fun onBindViewHolder(holder: PetHolder, position: Int) {
        holder.setData(listArray[position])
    }

    override fun getItemCount(): Int {
        return listArray.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateAdapter(listItems: List<String>) {
        listArray.apply {
            clear()
            addAll(listItems)
        }
        notifyDataSetChanged()
    }

    class PetHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvName: TextView = itemView.findViewById(R.id.tvPetName)

        fun setData(title: String) {
            tvName.text = title
        }

    }

}