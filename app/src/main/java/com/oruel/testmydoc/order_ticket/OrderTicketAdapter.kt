package com.oruel.testmydoc.order_ticket

import android.annotation.SuppressLint
import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.oruel.testmydoc.R
import com.oruel.testmydoc.R.color.cardview_bg
import com.oruel.testmydoc.date.getList

import com.oruel.testmydoc.date.toStr
import com.oruel.testmydoc.utils.DateItemViewHolder
import java.text.DateFormat
import java.time.LocalDate
import java.util.*


class OrderTicketAdapter(private val onItemClick:() -> Unit) : RecyclerView.Adapter<DateItemViewHolder>() {

    @RequiresApi(Build.VERSION_CODES.O)
    var data: List<LocalDate> = getList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount() = data.size


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: DateItemViewHolder, position: Int) {

        val item = data[position]

        holder.setText(item.toStr())



        holder.itemView.setOnClickListener{
            onItemClick()

        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DateItemViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater
            .inflate(R.layout.date_item_view_active, parent, false)
        return DateItemViewHolder(view)
    }


}