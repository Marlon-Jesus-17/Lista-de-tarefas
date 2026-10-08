package com.example.listadetarefas

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.w3c.dom.Text

@Composable
fun TarefasScreen(
    modifier: Modifier = Modifier
){

    var tarefas by remember {
        mutableStateOf(
            listOf(
                Tarefa(1, "Estudar Compose"),
                Tarefa(2, "Fazer exercício"),
                Tarefa(3, "Ler sobre Room")
            )
        )
    }

    var texto by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {

        OutlinedTextField(
            value = texto,
            onValueChange = {texto = it},
            label = {Text("Nova tarefa")},
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                val proximoId = (tarefas.maxOfOrNull { it.id }
                    ?: 0) + 1 //Pega o maior id da lista, se tiver vázia coloca 0

                if (texto.isNotBlank()){
                    tarefas = tarefas + Tarefa(proximoId, texto)
                    texto = ""
                }
            }
        ) {
            Text("Adicionar")
        }

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(tarefas){ tarefa ->
                Text(tarefa.titulo)
            }
        }

    }

}

@Composable
@Preview(showBackground = true)
fun TarefasScreenPreview(){
    TarefasScreen()
}