package com.oruel.testmydoc.data_class

data class Department(
    val department_id: String,
    val department_name: String,
    val department_rooms: List<DepartmentRoom>
)