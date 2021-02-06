package com.ranshiroirie.felicasystem.ui.database

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DatabaseMainViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Database Main Fragment"
    }
    val text: LiveData<String> = _text
}