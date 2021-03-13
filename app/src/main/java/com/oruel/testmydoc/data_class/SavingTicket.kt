package com.oruel.testmydoc.data_class

data class SavingTicket(
    val ticket: Ticket,
    val id_room: String,
    val room_name: String,
)

fun Room.createSavingTicket(ticket: Ticket): SavingTicket =
    SavingTicket(ticket,id_room,room_name)
