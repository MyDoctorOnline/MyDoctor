package com.oruel.testmydoc.order_ticket

import android.content.ClipData.Item
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.oruel.testmydoc.date.list

import java.util.*


class OrderTicketViewModel : ViewModel() {

    private var _dates = MutableLiveData<List<Date>>().apply {
        list
    }

    private val _text = MutableLiveData<String>().apply {
        value = "This is OrderTicketFragment"
    }
    val text: LiveData<String> = _text
}