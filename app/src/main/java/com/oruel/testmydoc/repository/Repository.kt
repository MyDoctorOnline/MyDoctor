package com.oruel.testmydoc.repository

import android.content.SharedPreferences
import androidx.lifecycle.MutableLiveData
import com.oruel.testmydoc.data_class.*
import com.oruel.testmydoc.repository.local.PreferencesDelegate
import com.oruel.testmydoc.repository.network.NetworkInterface
import com.oruel.testmydoc.repository.network.NetworkModule

class Repository(preferences: SharedPreferences) : RepositoryInterface {
    private val PREFERENCE_USER = "PREFERENCE_User"
    private val PREFERENCE_TICKET = "PREFERENCE_TICKET"
    private var preferencesUser by PreferencesDelegate(
        preferences,
        PREFERENCE_USER,
        User.mock()
    )
    private var preferencesTicket by PreferencesDelegate(
        preferences,
        PREFERENCE_TICKET,
        listOf<SavingTicket>()
    )
    private val networkServiceModule: NetworkInterface by lazy { NetworkModule() }

    override fun authorization(liveDataResponse: MutableLiveData<Int>, user: User) {
        preferencesUser = user
        liveDataResponse.postValue(200)
    }

    override fun isUserAuthorized(): Boolean = preferencesUser != User.mock()

    override fun authorizedUser(): User = preferencesUser

    override fun loadListDepartment(liveData: MutableLiveData<ListDepartment>) {
        networkServiceModule.getListDepartment(liveData)
    }

    override fun loadRoom(liveData: MutableLiveData<Room>, id: Long) {
        networkServiceModule.getRoom(liveData, id)
    }

    override fun chooseTicket(liveDataResponse: MutableLiveData<Int>, ticket: SavingTicket) {
        preferencesTicket = preferencesTicket + ticket
        liveDataResponse.postValue(200)
    }

    override fun getSelectedTicket(): List<SavingTicket> = preferencesTicket


}