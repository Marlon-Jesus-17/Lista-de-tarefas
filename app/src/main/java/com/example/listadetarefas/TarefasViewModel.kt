package com.example.listadetarefas

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel


data class TarefasUiState(
    val tarefas: List<Tarefa> = emptyList(),
    val filtro: Filtro = Filtro.TODAS
)

enum class Filtro {TODAS, PENDENTES, CONCLUIDAS}

class TarefasViewModel : ViewModel() {

    var uiState by mutableStateOf(TarefasUiState())
        private set //private set significa: qualquer um pode ler tarefas, mas só o ViewModel pode alterar.

    fun adicionar(titulo: String){
        if (titulo.isBlank()) return
        val proximoId = (uiState.tarefas.maxOfOrNull { it.id } ?: 0) + 1
        uiState = uiState.copy(tarefas = uiState.tarefas + Tarefa(proximoId, titulo))
    }

    fun alternarConcluida(id: Int){
        uiState = uiState.copy(
            tarefas = uiState.tarefas.map { item ->
                if (item.id == id)
                    item.copy(concluida = !item.concluida)
                else
                    item
            }
        )
    }

    fun remover(id: Int){
        uiState = uiState.copy(
            tarefas = uiState.tarefas.filter { item ->
                item.id != id
            }
        )
    }

    fun mudarFiltro(novo: Filtro){
        uiState = uiState.copy(
            filtro = novo
        )
    }
}