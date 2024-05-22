package com.example.odz.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.odz.model.Pet
import kotlinx.coroutines.flow.Flow

@Dao
interface PetDao {
    @Insert
    fun insertPet(pet: Pet)
    @Query("SELECT * FROM pets")
    fun getAllPets(): Flow<List<Pet>>
}