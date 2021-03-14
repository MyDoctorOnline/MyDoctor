package com.oruel.testmydoc.personal_area

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.oruel.testmydoc.R
import com.oruel.testmydoc.data_class.SavingTicket
import com.oruel.testmydoc.data_class.Ticket
import com.oruel.testmydoc.databinding.FragmentPersonalAreaBinding
import com.oruel.testmydoc.utils.Dialogs

class PersonalAreaFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = FragmentPersonalAreaBinding.inflate(inflater, container, false)
        val factory = ViewModelProvider.AndroidViewModelFactory(requireActivity().application)
        val adapter = SavingTicketAdapter(
            listOf(
                SavingTicket(Ticket("123", "123", "123"), "123", "123"),
                SavingTicket(Ticket("321", "321", "321"), "321", "321"),
                SavingTicket(Ticket("456", "456", "456"), "456", "456")
            ).createListPair()
        ) {}

        val layoutManager = StaggeredGridLayoutManager(
            1,
            LinearLayoutManager.VERTICAL
        )
        val vm = ViewModelProviders.of(
            this,
            factory
        ).get(PersonalAreaViewModel::class.java)

        view.adapterRecycler = adapter
        view.layoutManager = layoutManager
        view.vm = vm
        view.view = this
//        l(view.adapterRecycler.toString())
        vm.observeSavingTicket(adapter)
        return view.root
    }

    fun showAlert() {
        Dialogs("Сменить пользователя?",
            { findNavController().navigate(R.id.navigation_authorization) },
            { findNavController().navigate(R.id.navigation_personal_area) }).show(parentFragmentManager,"")
    }
}