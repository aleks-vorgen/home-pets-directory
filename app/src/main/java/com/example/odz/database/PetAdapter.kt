package com.example.odz.database

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.odz.R
import com.example.odz.model.Pet

class PetAdapter(listMain: ArrayList<Pet>) :
    RecyclerView.Adapter<PetAdapter.PetHolder>() {
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
    fun updateAdapter(listItems: List<Pet>) {
        listArray.clear()
        listArray.addAll(listItems)
        notifyDataSetChanged()
    }

    class PetHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvName: TextView = itemView.findViewById(R.id.tvPetName)

        fun setData(pet: Pet) {
            tvName.text = pet.name

            itemView.setOnClickListener {
                val bundle = Bundle().apply {
                    putSerializable("pet", pet)
                }

                val navController = Navigation.findNavController(itemView)
                navController.navigate(R.id.action_myPets_to_petInfoFragment, bundle)
            }
        }

    }

}