package com.oruel.testmydoc.order_ticket

import android.content.ClipData.Item
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*


class OrderTicketViewModel : ViewModel() {

    var selectedItem = MutableLiveData<Date>()

    private var _dates = MutableLiveData<List<Date>>().apply {
        listOf<Date>(
            Date(1991, 7, 8),
            Date(2001, 11, 11),
            Date(1054, 8, 23),
            Date(1851, 12, 12),
            Date(1331, 2, 28),
            Date(2021, 3, 13),
            Date(2020, 12, 31)
        )
    }

    val dates: LiveData<List<Date>> = _dates


    private val _text = MutableLiveData<String>().apply {
        value = "This is OrderTicketFragment"
    }
    val text: LiveData<String> = _text
}