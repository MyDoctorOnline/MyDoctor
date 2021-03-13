package com.oruel.testmydoc.order_ticket

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.oruel.testmydoc.R
import com.oruel.testmydoc.date.DateList
import com.oruel.testmydoc.utils.DateItemViewHolder
import java.text.DateFormat
import java.util.*


class OrderTicketAdapter(private val onItemClick:() -> Unit) : RecyclerView.Adapter<DateItemViewHolder>() {

    var data: List<Date> = DateList().list
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: DateItemViewHolder, position: Int) {

        val item = data[position]

        holder.textView.text = DateFormat.getDateInstance(DateFormat.DEFAULT, Locale("ru", "RU")).format(
            item as Date
        )
        holder.itemView.setOnClickListener{onItemClick()}

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DateItemViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater
            .inflate(R.layout.date_item_view, parent, false) as TextView
        return DateItemViewHolder(view)
    }


}