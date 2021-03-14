package com.oruel.testmydoc.call_doctor

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CallDoctorViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "+375 162 55-14-39"
    }
    val text: LiveData<String> = _text
}