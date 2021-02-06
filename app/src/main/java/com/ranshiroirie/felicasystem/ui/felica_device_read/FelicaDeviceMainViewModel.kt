package com.ranshiroirie.felicasystem.ui.felica_device_read

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FelicaDeviceMainViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Felica Device Main Fragment"
    }
    val text: LiveData<String> = _text
}