package com.ranshiroirie.felicasystem.ui.osaihu_read

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class OsaihuReadMainViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Osaihu Main Fragment"
    }
    val text: LiveData<String> = _text
}