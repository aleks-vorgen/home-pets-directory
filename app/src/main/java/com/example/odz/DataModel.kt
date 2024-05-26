package com.example.odz

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.odz.model.Pet

open class DataModel : ViewModel() {
    val pet: MutableLiveData<Pet> by lazy {
        MutableLiveData<Pet>()
    }
}