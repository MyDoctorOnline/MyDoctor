package com.oruel.testmydoc.order_ticket

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
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
        return view.root
    }
}