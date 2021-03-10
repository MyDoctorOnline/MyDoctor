package com.oruel.testmydoc.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.oruel.testmydoc.R
import com.oruel.testmydoc.databinding.FragmentDashboardBinding
import com.oruel.testmydoc.databinding.FragmentHomeBinding
import com.oruel.testmydoc.ui.dashboard.DashboardViewModel

class HomeFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val view = FragmentHomeBinding.inflate(inflater, container, false)
        view.vm = ViewModelProvider(this).get(HomeViewModel::class.java)
        return view.root
    }
}