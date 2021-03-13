package com.oruel.testmydoc.personal_area

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.oruel.testmydoc.databinding.FragmentPersonalAreaBinding
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.oruel.testmydoc.data_class.SavingTicket
import com.oruel.testmydoc.data_class.Ticket
import com.oruel.testmydoc.l

class PersonalAreaFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = FragmentPersonalAreaBinding.inflate(inflater, container, false)
        val factory = ViewModelProvider.AndroidViewModelFactory(activity!!.application)
        val adapter = ObserverSavingTicketAdapter(listOf(
            SavingTicket(Ticket("123", "123", "123"), "123", "123"),
            SavingTicket(Ticket("321", "321", "321"), "321", "321"),
            SavingTicket(Ticket("456", "456", "456"), "456", "456")
        ))
        val layoutManager = StaggeredGridLayoutManager(
            3,
            LinearLayoutManager.VERTICAL
        )
        val vm = ViewModelProviders.of(
            this,
            factory
        ).get(PersonalAreaViewModel::class.java)

        view.adapterRecycler = adapter
        view.layoutManager = layoutManager
        view.vm = vm

//        l(view.adapterRecycler.toString())
        vm.observeSavingTicket(adapter)
        return view.root
    }
}