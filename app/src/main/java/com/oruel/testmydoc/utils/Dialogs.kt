package com.oruel.testmydoc.utils

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class Dialogs(private val title:String,private val clickPositiveButton:()->Unit,private val clickNegativeButton:()->Unit): DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        super.onCreateDialog(savedInstanceState)
        return activity?.let {
            val builderDialog = androidx.appcompat.app.AlertDialog.Builder(it)
            builderDialog.setTitle(title)
//                    .setMessage("message")
                .setNegativeButton("No") { dialog, id ->
                    clickNegativeButton()
                }
                .setPositiveButton("Yea") { dialog, id ->
                    clickPositiveButton()
                }
                .create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }

}