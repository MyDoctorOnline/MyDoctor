package com.oruel.testmydoc.repository

import androidx.lifecycle.MutableLiveData
import com.oruel.testmydoc.data_class.ListDepartment
import com.oruel.testmydoc.data_class.Room
import com.oruel.testmydoc.data_class.SavingTicket
import com.oruel.testmydoc.data_class.User

interface RepositoryInterface {
    fun authorization(liveDataResponse: MutableLiveData<Int>, user: User)
    fun loadListDepartment(liveData: MutableLiveData<ListDepartment>)
    fun loadRoom(liveData: MutableLiveData<Room>, id: Long)
    fun chooseTicket(liveDataResponse: MutableLiveData<Int>, ticket: SavingTicket)
    fun authorizedUser(): User
    fun isUserAuthorized(): Boolean
    fun getSelectedTicket(): List<SavingTicket>
}