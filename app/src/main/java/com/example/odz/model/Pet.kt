package com.example.odz.model

class Pet (
    var id: String? = "",
    var name: String? = "",
    var breed: String? = "",
    var type: PetType? = PetType.DEFAULT,
    var age: Int = 0,
)