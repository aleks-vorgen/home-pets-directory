package com.example.odz

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.odz.database.PetAdapter
import com.example.odz.database.PetDatabaseManager
import com.example.odz.databinding.FragmentPetListBinding

class PetListFragment : Fragment() {
    private lateinit var binding: FragmentPetListBinding
    private lateinit var petDatabaseManager: PetDatabaseManager
    private lateinit var petAdapter: PetAdapter

    @SuppressLint("ResourceType")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPetListBinding
            .inflate(inflater, container, false)
        petDatabaseManager = PetDatabaseManager(requireContext())
        petAdapter = PetAdapter(ArrayList(), requireContext())

        initRecyclerView()

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

    private fun initRecyclerView() {
        binding.petListView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = petAdapter
        }
    }

    private fun fillAdapter() {
        val data = petDatabaseManager.readDbData()
        petAdapter.updateAdapter(data)
        if (data.isEmpty())
            binding.tvNoElements.visibility = View.VISIBLE
        else
            binding.tvNoElements.visibility = View.GONE
    }
}