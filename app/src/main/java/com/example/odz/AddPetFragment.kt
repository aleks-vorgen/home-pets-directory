package com.example.odz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.odz.database.PetAdapter
import com.example.odz.database.PetDatabaseManager
import com.example.odz.databinding.FragmentAddPetBinding
import com.example.odz.model.Pet
import com.skydoves.powerspinner.IconSpinnerAdapter
import com.skydoves.powerspinner.IconSpinnerItem

class AddPetFragment : Fragment() {
    private lateinit var binding: FragmentAddPetBinding
    private lateinit var petDatabaseManager: PetDatabaseManager
    private lateinit var petAdapter: PetAdapter
    private var selectedItem: String = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddPetBinding.inflate(inflater, container, false)
        initSpinnerDropdown()
        initOnButtonSaveClick()
        petAdapter = PetAdapter(ArrayList())
        petDatabaseManager = PetDatabaseManager(requireContext())

        return binding.root
    }



    override fun onDestroy() {
        super.onDestroy()
        petDatabaseManager.closeDb()
    }

    override fun onResume() {
        super.onResume()
        petDatabaseManager.openDb()
        fillAdapter()
    }

    private fun initOnButtonSaveClick() {
        binding.btnSavePet.setOnClickListener {
            if (!validateInputs()) {
                Toast.makeText(
                    requireContext(),
                    "Make sure you filled all of the inputs",
                    Toast.LENGTH_SHORT
                ).show()
            }
            else {
                val pet = Pet(
                    null,
                    binding.etPetName.text.toString(),
                    binding.etPetBreed.text.toString(),
                    Integer.parseInt(binding.etPetAge.text.toString()),
                    selectedItem
                )

                petDatabaseManager.insertToDB(
                    binding.etPetName.text.toString(),
                    binding.etPetBreed.text.toString(),
                    Integer.parseInt(binding.etPetAge.text.toString()),
                    selectedItem
                )
            }
        }
    }

    private fun validateInputs(): Boolean {
        return binding.etPetName.text.toString() != "" &&
                binding.etPetBreed.text.toString() != "" &&
                binding.etPetAge.text.toString() != "" &&
                selectedItem != ""
    }


    private fun initSpinnerDropdown() {
        binding.spPetType.apply {
            setSpinnerAdapter(IconSpinnerAdapter(binding.spPetType))
            setItems(
                arrayListOf(
                    IconSpinnerItem(text = "Cat"),
                    IconSpinnerItem(text = "Dog"),
                    IconSpinnerItem(text = "Hamster")
                )
            )

            getSpinnerRecyclerView().layoutManager = LinearLayoutManager(context)

            setOnSpinnerItemSelectedListener<IconSpinnerItem> { oldIndex, oldItem, newIndex, newText ->
                selectedItem = text.toString()
            }

            lifecycleOwner = this@AddPetFragment
        }
    }

    private fun fillAdapter() {
        petAdapter.updateAdapter(petDatabaseManager.readDbData())
    }
}