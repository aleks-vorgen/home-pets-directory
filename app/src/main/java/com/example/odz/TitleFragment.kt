package com.example.odz

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
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

        binding.btnReadFromDb.setOnClickListener {
            Navigation.createNavigateOnClickListener(R.id.action_titleFragment_to_petListFragment)
            Log.i(tag, "Clicked on btnReadFromDb")
        }

        return binding.root
    }
}