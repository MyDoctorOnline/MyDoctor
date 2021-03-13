package com.oruel.testmydoc.personal_area

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.oruel.testmydoc.data_class.SavingTicket
import com.oruel.testmydoc.data_class.Ticket

class PersonalAreaViewModel(application: Application) : AndroidViewModel(application) {
//    var observerSavingTicket: ObserverSavingTicket? = null
//    val liveData by lazy { MutableLiveData<SavingTicket>() }
    fun observeSavingTicket(observer: ObserverSavingTicket) {
        observer.update(listOf(SavingTicket(Ticket("123", "123", "123"), "123", "123"),
        SavingTicket(Ticket("321", "321", "321"), "321", "321"),
        SavingTicket(Ticket("456", "456", "456"), "456", "456")))
    }
}