package com.oruel.testmydoc.order_ticket


import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.oruel.testmydoc.date.getList


import java.util.*


class OrderTicketViewModel : ViewModel() {

//    @RequiresApi(Build.VERSION_CODES.O)
//    private var _dates = MutableLiveData<List<Date>>().apply {
//        getList()
//    }

    private val _text = MutableLiveData<String>().apply {
        value = "This is OrderTicketFragment"
    }
    val text: LiveData<String> = _text
}