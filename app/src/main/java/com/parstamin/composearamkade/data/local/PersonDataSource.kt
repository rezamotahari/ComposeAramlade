package com.parstamin.composearamkade.data.local


import com.parstamin.composearamkade.User
import kotlinx.coroutines.flow.Flow

interface PersonDataSource {


    fun getAllPersons(): Flow<List<User>>
    suspend fun getPersonById(id: Long): User?
    suspend fun deletePersonById(id: Long)
    suspend fun insertPerson(firstName: String, lastName: String, id: Long? = null)
}