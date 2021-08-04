package com.harshil.daggerhilt.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(): ViewModel() {
    val userLiveData = MutableLiveData<String>()

    init {
        getUsers()
    }
    fun getUsers() {
        userLiveData.value = "Harshil"
    }
}