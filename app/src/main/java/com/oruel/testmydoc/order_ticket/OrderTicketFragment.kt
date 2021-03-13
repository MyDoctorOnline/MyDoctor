package com.oruel.testmydoc.order_ticket

import android.content.ClipData.Item
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.iterator
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
}