package com.oruel.testmydoc.utils

import android.util.Log
import android.view.View
import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView
import com.oruel.testmydoc.R

class DateItemViewHolder(val view: View) : RecyclerView.ViewHolder(view){

    fun setText(s:String){
        view.findViewById<TextView>(R.id.simple_date).text = s
    }
}

fun l(s:String){
    Log.v("MyTag",s)
}