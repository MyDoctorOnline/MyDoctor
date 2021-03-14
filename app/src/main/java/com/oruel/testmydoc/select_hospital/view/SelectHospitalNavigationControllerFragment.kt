package com.oruel.testmydoc.select_hospital.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.oruel.testmydoc.R
import com.oruel.testmydoc.databinding.FragmentSelectHospitalBinding
import com.oruel.testmydoc.select_hospital.SelectHospitalViewModel

class SelectHospitalNavigationControllerFragment : Fragment(), SelectHospitalNavigationControllerInterface{

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val view = FragmentSelectHospitalBinding.inflate(inflater, container, false)
        view.vm = ViewModelProvider(this).get(SelectHospitalViewModel::class.java)
        view.navigationController = this
        return view.root
    }

    override fun navigateOrderTicket(){
        findNavController().navigate(R.id.navigation_order_ticket)
    }

    override fun navigateCallDoctor(){
        findNavController().navigate(R.id.navigation_order_ticket)
    }

}
