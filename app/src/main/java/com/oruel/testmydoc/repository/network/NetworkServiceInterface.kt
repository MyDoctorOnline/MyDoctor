package com.oruel.testmydoc.repository.network

import com.oruel.testmydoc.data_class.Department
import com.oruel.testmydoc.data_class.ListDepartment
import com.oruel.testmydoc.data_class.Room
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkServiceInterface {
    @GET("DisplayScheduleWorkCabinet.php")
    fun getListDepartment(): Call<ListDepartment>

    @GET("DisplaySheduleOpenSlot.php")
    fun getRoom(@Query("Cabinet")id:Long): Call<Room>

}