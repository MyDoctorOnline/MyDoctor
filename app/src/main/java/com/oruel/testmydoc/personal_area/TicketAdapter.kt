package com.oruel.testmydoc.personal_area

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.oruel.testmydoc.R
import com.oruel.testmydoc.data_class.Ticket

class TicketAdapter(private val ticketList: List<Ticket>): RecyclerView.Adapter<TicketAdapter.TicketViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TicketViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.fragment_personal_area, parent, false)

        return TicketViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: TicketViewHolder, position: Int) {
        val currentTicket = ticketList[position]

        //currentTicket name should be passed to ticket_name textView
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    class TicketViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val ticketName: TextView = itemView.findViewById(R.id.ticket_name)

    }

}