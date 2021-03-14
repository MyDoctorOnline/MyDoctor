package com.oruel.testmydoc.order_ticket


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.oruel.testmydoc.R
import com.oruel.testmydoc.utils.l

class SelectTicketAdapter(
    private var ticketList: List<String>,
    private val onClick: (Int) -> Unit
) :
    RecyclerView.Adapter<SelectTicketAdapter.TicketSelectViewHolder>(), ObserverSelectTicket {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TicketSelectViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_holder_ticket_select, parent, false)


        return TicketSelectViewHolder(itemView, onClick)
    }

    override fun onBindViewHolder(holder: TicketSelectViewHolder, position: Int) {
        holder.setTicket(ticketList[position], position)
    }

    override fun getItemCount() = ticketList.size

    override fun update(ticketList: List<String>) {
        this.ticketList = ticketList
        l(ticketList.toString())
        notifyDataSetChanged()
    }

    class TicketSelectViewHolder(itemView: View, private val onClick: (Int) -> Unit) :
        RecyclerView.ViewHolder(itemView) {
        private val container: View = itemView.findViewById(R.id.containerHolderSelect)
        private val ticketRoomName: TextView = itemView.findViewById(R.id.ticket_select_room_name)

        //            private val ticketTime: TextView = itemView.findViewById(R.id.ticket_time_select)
        private var _position1: Int? = null

        fun getPposition(): Int = if (_position1 != null) _position1!! else -1

        init {
            container.setOnClickListener {
                onClick(getPposition())
            }
        }

        fun setTicket(ticket: String, position: Int) {
//                val (title, nameDoc) = ticket
            ticketRoomName.text = ticket     //ticket.room_name      in SavingTicket
//                ticketTime.text = nameDoc       //ticket.ticket.time    in SavingTicket
            this._position1 = position
        }
    }

}

interface ObserverSelectTicket {
    fun update(ticketList: List<String>)
}

//    fun Collection<SavingTicket>.createListPair(): List<Pair<String, String>> =
//        map { Pair(it.room_name, it.ticket.time) }
//    fun Collection<SavingTicket>.createListPairSelectTicket(): List<Pair<String, String>> =
//        map { Pair(it.room_name, "") }