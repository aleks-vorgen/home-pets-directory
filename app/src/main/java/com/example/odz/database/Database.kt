package com.example.odz.database

import androidx.room.Room
import androidx.room.RoomDatabase
import android.content.Context
import com.example.odz.dao.PetDao
import com.example.odz.model.Pet

@androidx.room.Database(entities = [Pet::class], version = 1)
abstract class Database : RoomDatabase() {

    abstract fun getDao(): PetDao

    companion object {
        fun getDatabase(context: Context): Database {
            return Room.databaseBuilder(
                context.applicationContext, Database::class.java, "pets.db"
            ).build()
        }
    }
}