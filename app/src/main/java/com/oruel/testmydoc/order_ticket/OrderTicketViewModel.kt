package com.oruel.testmydoc.order_ticket

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class OrderTicketViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is OrderTicketFragment"
    }
    val text: LiveData<String> = _text
}