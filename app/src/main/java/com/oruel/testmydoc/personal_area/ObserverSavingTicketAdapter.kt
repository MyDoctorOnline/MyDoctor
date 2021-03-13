package com.oruel.testmydoc.personal_area

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.oruel.testmydoc.R
import com.oruel.testmydoc.data_class.SavingTicket
import com.oruel.testmydoc.l

class ObserverSavingTicketAdapter(private var ticketList: List<SavingTicket>) :
    RecyclerView.Adapter<ObserverSavingTicketAdapter.TicketViewHolder>(), ObserverSavingTicket {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TicketViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_holder_tickets, parent, false)

        return TicketViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: TicketViewHolder, position: Int) {
        holder.setTicket(ticketList[position])
    }

    override fun getItemCount() = ticketList.size

    override fun update(ticketList: List<SavingTicket>) {
        this.ticketList = ticketList
        l(ticketList.toString())
        notifyDataSetChanged()
    }

    class TicketViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        private val ticketRoomName: TextView = itemView.findViewById(R.id.ticket_room_name)
        private val ticketTime: TextView = itemView.findViewById(R.id.ticket_time)

        fun setTicket(ticket: SavingTicket){
            ticketRoomName.text = ticket.room_name
            ticketTime.text = ticket.ticket.time
        }
    }
}

interface ObserverSavingTicket {
    fun update(ticketList: List<SavingTicket>)
}