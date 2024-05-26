package com.example.odz.database

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.util.Log
import com.example.odz.model.Pet

class PetDatabaseManager(context: Context) {
    private val petDatabaseHelper = PetDatabaseHelper(context)
    private var db: SQLiteDatabase? = null

    fun openDb() {
        db = petDatabaseHelper.writableDatabase
    }

    fun insertToDB(name: String, breed: String, age: Int, type: String) {
        val values = ContentValues().apply {
            put(PetDatabaseNameClass.COLUMN_NAME_NAME, name)
            put(PetDatabaseNameClass.COLUMN_NAME_BREED, breed)
            put(PetDatabaseNameClass.COLUMN_NAME_AGE, age)
            put(PetDatabaseNameClass.COLUMN_NAME_TYPE, type)
        }

        db?.insert(PetDatabaseNameClass.TABLE_NAME, null, values)
    }

    @SuppressLint("Range")
    fun readDbData(): ArrayList<Pet> {
        val dataList = java.util.ArrayList<Pet>()
        val cursor = db?.query(PetDatabaseNameClass.TABLE_NAME, null, null, null, null, null, null)

        while (cursor?.moveToNext()!!) {
            val pet = Pet(
                cursor.getColumnIndex(PetDatabaseNameClass.COLUMN_NAME_ID),
                cursor.getString(cursor.getColumnIndex(PetDatabaseNameClass.COLUMN_NAME_NAME)),
                cursor.getString(cursor.getColumnIndex(PetDatabaseNameClass.COLUMN_NAME_BREED)),
                cursor.getInt(cursor.getColumnIndex(PetDatabaseNameClass.COLUMN_NAME_AGE)),
                cursor.getString(cursor.getColumnIndex(PetDatabaseNameClass.COLUMN_NAME_TYPE))
            )
            dataList.add(pet)
        }

        cursor.close()

        Log.i("DATA LIST", dataList.toString())
        return dataList
    }

    fun closeDb() {
        petDatabaseHelper.close()
    }
}