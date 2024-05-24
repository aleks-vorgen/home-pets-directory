package com.example.odz.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class PetDatabaseHelper(context: Context) : SQLiteOpenHelper(context, PetDatabaseNameClass.DATABASE_NAME, null, PetDatabaseNameClass.DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(PetDatabaseNameClass.CREATE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL(PetDatabaseNameClass.SQL_DELETE_TABLE)
        onCreate(db)
    }
}