package com.example.listadetarefas

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TarefasScreen(
    modifier: Modifier = Modifier
){
    val tarefas = List(30){ indice ->
        Tarefa(indice, "Tarefa de número ${indice + 1}", concluida = indice % 2 == 0)
    }

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(tarefas){ tarefa ->
            val texto = if (tarefa.concluida) "${tarefa.titulo} (feita)" else tarefa.titulo
            Text(texto)
        }
    }

}

@Composable
@Preview(showBackground = true)
fun TarefasScreenPreview(){
    TarefasScreen()
}