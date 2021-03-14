package com.oruel.testmydoc.utils

import android.os.Build
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.annotation.RequiresApi

import androidx.recyclerview.widget.RecyclerView
import com.oruel.testmydoc.R
import java.time.LocalDate

class DateItemViewHolder(val view: View) : RecyclerView.ViewHolder(view){

    fun setText(s:String){
        view.findViewById<TextView>(R.id.simple_date).text = s
    }
}

fun l(s:String){
    Log.v("MyTag",s)
}

@RequiresApi(Build.VERSION_CODES.O)
fun String.toDate(): LocalDate {
    return LocalDate.parse(this)
}

@RequiresApi(Build.VERSION_CODES.O)
fun LocalDate.toStr(): String {
    return "${this.dayOfMonth}.${this.month.value}"
}