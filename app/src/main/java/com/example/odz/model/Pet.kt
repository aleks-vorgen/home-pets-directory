package com.example.odz.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pets")
class Pet(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    @ColumnInfo(name = "name")
    var name: String = "",
    @ColumnInfo(name = "breed")
    var breed: String = "",
    @ColumnInfo(name = "type")
    var type: String = PetType.DEFAULT,
    @ColumnInfo(name = "age")
    var age: Int = 0,
)