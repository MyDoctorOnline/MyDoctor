package com.oruel.testmydoc.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.oruel.testmydoc.R
import com.oruel.testmydoc.databinding.FragmentDashboardBinding

class CallDoctorFragment : Fragment() {

    lateinit var view: FragmentDashboardBinding

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        view = FragmentDashboardBinding.inflate(inflater, container, false)
        view.vm = ViewModelProvider(this).get(DashboardViewModel::class.java)
        return view.root
    }
}