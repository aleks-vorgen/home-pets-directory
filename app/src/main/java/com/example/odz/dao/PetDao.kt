package com.example.odz.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.odz.model.Pet

@Dao
interface PetDao {
    @Insert
    fun insertPet(pet: Pet)
    @Query("SELECT * FROM pets")
    fun getAllPets(): List<Pet>
    @Query("SELECT name FROM pets")
    fun getPetNames(): List<String>
    @Delete
    fun deletePet(pet: Pet)
    @Update
    fun updatePet(pet: Pet)
    @Query("DELETE FROM pets")
    fun deleteAllPets()
    @Query("SELECT * FROM pets WHERE id = :id")
    fun getPet(id: Long): Pet
}