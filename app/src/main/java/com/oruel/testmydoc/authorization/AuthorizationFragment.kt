package com.oruel.testmydoc.authorization

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.oruel.testmydoc.databinding.FragmentAuthorizationBinding

class AuthorizationFragment:Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = FragmentAuthorizationBinding.inflate(inflater, container, false)
        view.vm = ViewModelProvider(this).get(AuthorizationViewModel::class.java)
        return view.root
    }
}