package com.parstamin.composearamkade.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.parstamin.composearamkade.User
import com.parstamin.composearamkade.data.local.PersonDataSource
import kotlinx.coroutines.launch

class PersonListViewModel (
    private val personDataSource: PersonDataSource
): ViewModel() {

    val persons = personDataSource.getAllPersons()

    var personDetails by mutableStateOf<User?>(null)
        private set

    var firstNameText by mutableStateOf("")
        private set
    var lastNameText by mutableStateOf("")
        private set

    fun onInsertPersonClick() {
        if(firstNameText.isBlank() || lastNameText.isBlank()) {
            return
        }
        viewModelScope.launch {
            personDataSource.insertPerson(firstNameText, lastNameText)
            firstNameText = ""
            lastNameText = ""
        }
    }



    fun onDeleteClick(id: Long) {
        viewModelScope.launch {
            personDataSource.deletePersonById(id)
        }
    }

    fun getPersonById(id: Long) {
        viewModelScope.launch {
            personDetails = personDataSource.getPersonById(id)
        }
    }

    fun onFirstNameChange(value: String) {
        firstNameText = value
    }

    fun onLastNameChange(value: String) {
        lastNameText = value
    }

    fun onPersonDetailsDialogDismiss() {
        personDetails = null
    }
}