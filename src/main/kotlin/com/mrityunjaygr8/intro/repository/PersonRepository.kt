package com.mrityunjaygr8.intro.repository

import com.mrityunjaygr8.intro.domain.Person
import org.springframework.stereotype.Repository

@Repository
class PersonRepository(private val persons: MutableList<Person> = mutableListOf()) {
    fun findById(id: Int): Person? = persons.find{ it.id == id}

    fun findAll(): MutableList<Person> = persons

    fun delete(id: Int) = persons.removeIf { it.id == id }

    fun add(person: Person) = persons.add(person)

    fun update(person: Person) {
        val index = persons.indexOfFirst { it.id == person.id }
        persons[index] = person
    }
}