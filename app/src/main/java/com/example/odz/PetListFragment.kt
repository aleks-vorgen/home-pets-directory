package com.example.odz

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.odz.databinding.FragmentPetListBinding
import com.example.odz.model.Pet
import com.example.odz.model.PetType
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.GenericTypeIndicator
import com.google.firebase.database.ValueEventListener

class PetListFragment : Fragment() {

    private var database = FirebaseDatabase.getInstance()
    private var petsRef = database.getReference("pets")
    private var dogRef = database.getReference(PetType.DOG)
    private lateinit var binding: FragmentPetListBinding
    private lateinit var pets: List<Pet>
    private lateinit var listPetView: ListView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentPetListBinding = DataBindingUtil
            .inflate(inflater, R.layout.fragment_pet_list, container, false)!!
        listPetView = binding.petListView
        getPets()

        return binding.root
    }

    private fun getPets() {
        petsRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                Log.d("PETS_REF", petsRef.toString())
                Log.d("PETS_DATA",
                    snapshot.child("pets/cats").toString()
                )
                val t: GenericTypeIndicator<List<Pet>>
                pets =
                    snapshot.child("pets/cats").getValue(object : GenericTypeIndicator<List<Pet>>() {})!!

                updateUI()
            }

            private fun updateUI() {
                val adapter: ArrayAdapter<Pet> =
                    ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, pets)
                listPetView.adapter = adapter
            }

            override fun onCancelled(error: DatabaseError) {
                Log.e(tag, "Error retrieving pets from database")
            }
        })
    }
}