package com.oruel.testmydoc.call_doctor

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.oruel.testmydoc.databinding.FragmentCallDoctorBinding

class CallDoctorFragment : Fragment() {

//    lateinit var view: FragmentDashboardBinding

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val view = FragmentCallDoctorBinding.inflate(inflater, container, false)
        view.vm = ViewModelProvider(this).get(CallDoctorViewModel::class.java)
        return view.root
    }
}