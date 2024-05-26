package com.example.odz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.odz.databinding.FragmentPetInfoBinding
import com.example.odz.model.Pet

class PetInfoFragment : Fragment() {
    private lateinit var binding: FragmentPetInfoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPetInfoBinding
            .inflate(inflater, container, false)

        arguments?.let {
            val pet = it.getSerializable("pet") as Pet

            binding.tvPetName.text = pet.name
            binding.tvPetBreed.text = pet.breed
            binding.tvPetAge.text = pet.age.toString()
            binding.tvPetType.text = pet.type
        }

        return binding.root
    }

}