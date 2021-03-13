package com.oruel.testmydoc.order_ticket


import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter


import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.oruel.testmydoc.R
import com.oruel.testmydoc.data_class.Department
import com.oruel.testmydoc.data_class.DepartmentRoom

import com.oruel.testmydoc.databinding.FragmentOrderTicketBinding
import com.oruel.testmydoc.repository.Repository
import com.oruel.testmydoc.repository.local.createSharedPreferences


class OrderTicketFragment : Fragment() {
//    val departments = Repository(createSharedPreferences(requireContext()))
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = FragmentOrderTicketBinding.inflate(inflater, container, false)
        view.vm = ViewModelProvider(this).get(OrderTicketViewModel::class.java)
        return view.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val all_rooms: Array<String> = arrayOf("1","2","3")
        val rooms: Spinner = view.findViewById(R.id.rooms)
        val adapter = ArrayAdapter(
            requireContext(), // Context
            android.R.layout.simple_spinner_item, // Layout
        all_rooms
        )
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
        rooms.adapter = adapter


    }
}