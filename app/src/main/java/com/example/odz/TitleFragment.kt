package com.example.odz

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.odz.databinding.FragmentTitleBinding
import com.google.firebase.database.DatabaseReference

class TitleFragment : Fragment() {
    private lateinit var dataBase: DatabaseReference

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentTitleBinding = DataBindingUtil
            .inflate(inflater, R.layout.fragment_title, container, false)!!

        //val view = inflater.inflate(R.layout.fragment_title, container, false)
        //val button = view.findViewById<Button>(R.id.btn_read_from_db)
        binding.btnReadFromDb.setOnClickListener {
            findNavController().navigate(R.id.action_titleFragment_to_petListFragment)
        }

        return binding.root
    }
}