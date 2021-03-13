package com.oruel.testmydoc.personal_area

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.oruel.testmydoc.R
import com.oruel.testmydoc.data_class.SavingTicket

class TicketAdapter(val viewmodel: PersonalAreaViewModel, private val ticketList: List<SavingTicket>): RecyclerView.Adapter<TicketAdapter.TicketViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TicketViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.fragment_personal_area, parent, false)

        return TicketViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: TicketViewHolder, position: Int) {
        val currentTicket = ticketList[position]

        holder.ticketRoomName.text = currentTicket.room_name
        holder.ticketTime.text = currentTicket.ticket.time
    }

    override fun getItemCount() = ticketList.size

    class TicketViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var ticketRoomName: TextView = itemView.findViewById(R.id.ticket_room_name)
        var ticketTime: TextView= itemView.findViewById(R.id.ticket_time)

    }
}