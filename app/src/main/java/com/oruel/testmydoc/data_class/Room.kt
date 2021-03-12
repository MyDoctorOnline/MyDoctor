package com.oruel.testmydoc.data_class

data class Room(
    val id_room: String,
    val room_Doctor: Any,
    val room_name: String,
    val room_number: Any,
    val week_tickets: List<WeekTicket>
)