package com.example.odz.database

import android.provider.BaseColumns

object PetDatabaseNameClass {
    const val TABLE_NAME = "pets"
    const val COLUMN_NAME_ID = "id"
    const val COLUMN_NAME_NAME = "name"
    const val COLUMN_NAME_BREED = "breed"
    const val COLUMN_NAME_TYPE = "type"
    const val COLUMN_NAME_AGE = "age"

    const val DATABASE_VERSION = 1
    const val DATABASE_NAME = "PetsDirectory.db"

    const val CREATE_TABLE = "CREATE TABLE IF NOT EXISTS $TABLE_NAME " +
            "(${BaseColumns._ID} INTEGER PRIMARY KEY, $COLUMN_NAME_NAME TEXT," +
            "$COLUMN_NAME_BREED TEXT, $COLUMN_NAME_TYPE TEXT, $COLUMN_NAME_AGE INTEGER)"

    const val SQL_DELETE_TABLE = "DROP TABLE IF EXISTS $TABLE_NAME"
}