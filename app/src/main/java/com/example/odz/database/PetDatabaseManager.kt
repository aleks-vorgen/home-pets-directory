package com.example.odz.database

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.util.Log

class PetDatabaseManager(context: Context) {
    private val petDatabaseHelper = PetDatabaseHelper(context)
    private var db: SQLiteDatabase? = null

    fun openDb() {
        db = petDatabaseHelper.writableDatabase
    }

    fun insertToDB(name: String, breed: String, type: String, age: Int) {
        val values = ContentValues().apply {
            put(PetDatabaseNameClass.COLUMN_NAME_NAME, name)
            put(PetDatabaseNameClass.COLUMN_NAME_BREED, breed)
            put(PetDatabaseNameClass.COLUMN_NAME_TYPE, type)
            put(PetDatabaseNameClass.COLUMN_NAME_AGE, age)
        }

        db?.insert(PetDatabaseNameClass.TABLE_NAME, null, values)
    }

    @SuppressLint("Range")
    fun readDbData(): ArrayList<String> {
        val dataList = java.util.ArrayList<String>()
        val cursor = db?.query(PetDatabaseNameClass.TABLE_NAME, null, null, null, null, null, null)

        while (cursor?.moveToNext()!!) {
            val dataText =
                cursor.getString(cursor.getColumnIndex(PetDatabaseNameClass.COLUMN_NAME_NAME))
            dataList.add(dataText.toString())
        }

        cursor.close()

        Log.i("DATA LIST", dataList.toString())
        return dataList
    }

    fun closeDb() {
        petDatabaseHelper.close()
    }
}