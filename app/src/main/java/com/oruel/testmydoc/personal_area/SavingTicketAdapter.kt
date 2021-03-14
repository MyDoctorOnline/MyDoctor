package com.oruel.testmydoc.personal_area

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.oruel.testmydoc.R
import com.oruel.testmydoc.data_class.SavingTicket
import com.oruel.testmydoc.utils.l
import okhttp3.internal.Util

class SavingTicketAdapter(private var ticketList: List<Pair<String, String>>, private val onClick: (Int) -> Unit) :
    RecyclerView.Adapter<SavingTicketAdapter.TicketViewHolder>(), ObserverSavingTicket {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TicketViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_holder_tickets, parent, false)


        return TicketViewHolder(itemView,onClick)
    }

    override fun onBindViewHolder(holder: TicketViewHolder, position: Int) {
        holder.setTicket(ticketList[position],position)
    }

    override fun getItemCount() = ticketList.size

    override fun update(ticketList: List<Pair<String, String>>) {
        this.ticketList = ticketList
        l(ticketList.toString())
        notifyDataSetChanged()
    }

    class TicketViewHolder(itemView: View, private val onClick: (Int) -> Unit) :
        RecyclerView.ViewHolder(itemView) {
        private val container: View = itemView.findViewById(R.id.containerHolder)
        private val ticketRoomName: TextView = itemView.findViewById(R.id.ticket_room_name)
        private val ticketTime: TextView = itemView.findViewById(R.id.ticket_time)
        private var _position1: Int? = null

        fun getPposition(): Int = if (_position1 != null) _position1!! else -1

        init {
            container.setOnClickListener {
                onClick(getPposition())
            }
        }

        fun setTicket(ticket: Pair<String, String>, position: Int) {
            val (title, nameDoc) = ticket
            ticketRoomName.text = title     //ticket.room_name      in SavingTicket
            ticketTime.text = nameDoc       //ticket.ticket.time    in SavingTicket
            this._position1 = position
        }
    }

}

interface ObserverSavingTicket {
    fun update(ticketList: List<Pair<String, String>>)
}

fun Collection<SavingTicket>.createListPair(): List<Pair<String, String>> =
    map { Pair(it.room_name, it.ticket.time) }
fun Collection<SavingTicket>.createListPairSelectTicket(): List<Pair<String, String>> =
    map { Pair(it.room_name, "") }