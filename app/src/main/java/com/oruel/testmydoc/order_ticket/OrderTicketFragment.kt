package com.oruel.testmydoc.order_ticket

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.iterator
import android.widget.ArrayAdapter


import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.oruel.testmydoc.R
import com.oruel.testmydoc.data_class.SavingTicket
import com.oruel.testmydoc.data_class.Ticket
import com.oruel.testmydoc.databinding.FragmentOrderTicketBinding
import com.oruel.testmydoc.personal_area.SavingTicketAdapter
import com.oruel.testmydoc.personal_area.createListPair
import com.oruel.testmydoc.personal_area.createListPairSelectTicket


class OrderTicketFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = FragmentOrderTicketBinding.inflate(inflater, container, false)
        view.vm = ViewModelProvider(this).get(OrderTicketViewModel::class.java)
        val adapter = OrderTicketAdapter {
            Toast.makeText(requireContext(), "11", Toast.LENGTH_SHORT).show()
        }
        view.horizontalList.adapter = adapter


        for (item in view.horizontalList) {
            item.setOnClickListener {
                Toast.makeText(requireContext(), "11", Toast.LENGTH_SHORT).show()
            }
        }



        return view.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val all_rooms: Array<String> = arrayOf("Кабинеты химиотерапевтов - 309 Хирург ", "Кабинеты онкологов - 203 Онколог", "Прием заведующих")
        val rooms: Spinner = view.findViewById(R.id.rooms)
        val recyclerViewTicket: RecyclerView = view.findViewById(R.id.choose_tickets)
        val adapter = ArrayAdapter(
            requireContext(), // Context
            android.R.layout.simple_spinner_item, // Layout
            all_rooms
        )
        rooms.adapter = adapter
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
        val adapterSelectTicket = SelectTicketAdapter(
            listOf("8.30","9.00","9.30","10.00",
                    "10.30","11.00","12.00","12.30",
                    "13.00","13.30","14.00","14.30",
                    "15.00","15.30","16.00","16.30",
                    "17.30","18.00","18.30","19.00",
                    "19.30","20.00")
        ) {}
        recyclerViewTicket.adapter = adapterSelectTicket
        val layoutManager = StaggeredGridLayoutManager(
            4,
            LinearLayoutManager.VERTICAL
        )
        recyclerViewTicket.layoutManager = layoutManager

    }
}