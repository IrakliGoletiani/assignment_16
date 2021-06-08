package com.example.roomdatabase

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel : ViewModel() {

    private val _persons = MutableLiveData<List<Person>>()
    val persons: LiveData<List<Person>> = _persons

    fun read() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                _persons.postValue(PersonDatabase.db.personDao().getAll())
            }
        }
    }

    fun write(person: Person) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                PersonDatabase.db.personDao().insertAll(person)
            }
        }
    }
}