package com.oruel.testmydoc.repository.network

import androidx.lifecycle.MutableLiveData
import com.oruel.testmydoc.data_class.ListDepartment
import com.oruel.testmydoc.data_class.Room

interface NetworkInterface {
    fun getListDepartment(liveData: MutableLiveData<ListDepartment>)
    fun getRoom(liveData: MutableLiveData<Room>, id: Long)
}