package com.oruel.testmydoc.data_class

data class User(
    val firstName: String,
    val lastName: String
){
    companion object{
        fun mock():User = User("","")
    }
}
