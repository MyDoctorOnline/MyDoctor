package com.oruel.testmydoc.utils

import android.util.Log
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DateItemViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)

fun l(s:String){
    Log.v("MyTag",s)
}