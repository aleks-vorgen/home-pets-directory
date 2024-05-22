package com.example.odz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.example.odz.database.Database
import com.example.odz.databinding.FragmentAddPetBinding
import com.example.odz.databinding.FragmentPetListBinding
import com.example.odz.model.Pet
import com.example.odz.model.PetType

class AddPetFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentAddPetBinding = FragmentAddPetBinding
            .inflate(inflater, container, false)

        val db = Database.getDatabase(requireContext())
        binding.btnSavePet.setOnClickListener {
            val pet = Pet(
                null,
                binding.etPetName.text.toString(),
                binding.etPetBreed.text.toString(),
                PetType.DOG,
                Integer.parseInt(binding.etPetAge.text.toString())
            )
            Thread {
                db.getDao().insertPet(pet)
            }.start()
        }

        return binding.root
    }
}