package com.example.listadetarefas

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class TarefasViewModel : ViewModel() {

    var tarefas by mutableStateOf(listOf<Tarefa>())
        private set //private set significa: qualquer um pode ler tarefas, mas só o ViewModel pode alterar.

    fun adicionar(titulo: String){
        if (titulo.isBlank()) return
        val proximoId = (tarefas.maxOfOrNull { it.id } ?: 0) + 1
        tarefas = tarefas + Tarefa(proximoId, titulo)
    }
}