package com.example.enidemo.model

object PersonManager {

    fun getPersonId(Id : Int) : MetierResponse<Person> {
        val person = Person(1, "Deni", 10) // get
        var response = MetierResponse<Person>("801", "Personne succès", person)

        return response
    }

    fun getAllPerson(Id : Int) : MetierResponse<ArrayList<Person>> {
        val personList : ArrayList<Person> = arrayListOf(Person(1, "Deni", 10) , Person(2, "Gaetan", 10))
        var response = MetierResponse<ArrayList<Person>>("802", "Les Personnes succès", personList)

        return response
    }
}