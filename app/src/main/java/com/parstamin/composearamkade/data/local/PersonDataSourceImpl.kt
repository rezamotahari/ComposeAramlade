package com.parstamin.composearamkade.data.local


import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import com.parstamin.composearamkade.User
import com.parstamin.composearamkade.db.Database
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class PersonDataSourceImpl(
    db: Database
) : PersonDataSource {

    private val queries = db.userQueries
    override fun getAllPersons(): Flow<List<User>> {

        return queries.getAllUser().asFlow().mapToList(Dispatchers.Default)
    }

    override suspend fun getPersonById(id: Long): User? {
        return withContext(Dispatchers.IO) {
            queries.getUserById(id).executeAsOneOrNull()
        }
    }

    override suspend fun deletePersonById(id: Long) {
        withContext(Dispatchers.IO) {
            queries.deleteUserById(id)
        }
    }

    override suspend fun insertPerson(firstName: String, lastName: String, id: Long?) {
        withContext(Dispatchers.IO) {
            queries.insertUse(id, firstName, lastName)
        }
    }

}