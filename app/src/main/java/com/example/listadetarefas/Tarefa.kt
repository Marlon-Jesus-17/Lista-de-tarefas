package com.example.listadetarefas

data class Tarefa(
    val id: Int,
    val titulo: String,
    val concluida: Boolean = false
)
