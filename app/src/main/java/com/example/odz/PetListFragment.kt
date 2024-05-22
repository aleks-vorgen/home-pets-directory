package com.example.odz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.asLiveData
import com.example.odz.database.Database
import com.example.odz.databinding.FragmentPetListBinding

class PetListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentPetListBinding = FragmentPetListBinding
            .inflate(inflater, container, false)

        val db = Database.getDatabase(requireContext())
        db.getDao().getAllPets()

        return binding.root
    }


}