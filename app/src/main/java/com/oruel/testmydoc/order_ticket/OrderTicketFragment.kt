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
import com.oruel.testmydoc.databinding.FragmentOrderTicketBinding


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


        for(item in view.horizontalList){
            item.setOnClickListener{
                Toast.makeText(requireContext(), "11", Toast.LENGTH_SHORT).show()
            }
        }

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