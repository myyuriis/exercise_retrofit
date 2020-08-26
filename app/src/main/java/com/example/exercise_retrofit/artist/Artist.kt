package com.example.exercise_retrofit.artist

class Artist(val id: String = "",
             val name: String = "",
             val username: String = "",
             val email: String = ""
//             val address: Address
)

data class Address(val street: String = "",
                   val suite: String = "",
                   val city: String = "",
                   val zipcode: String = "")