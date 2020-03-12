package com.example.chcenter.models

data class ProgramModel(var name:String,var venue:String, var date:String, var contact:String)

object Programlist {
    val programs = listOf(
        ProgramModel("program1" ,"nilambur","22/12/2020","9048080829"),
        ProgramModel("program1" ,"nilambur","22/12/2020","9048080829"),
        ProgramModel("program1" ,"nilambur","22/12/2020","9048080829"),
        ProgramModel("program1" ,"nilambur","22/12/2020","9048080829"),
        ProgramModel("program1" ,"nilambur","22/12/2020","9048080829")


    )
}