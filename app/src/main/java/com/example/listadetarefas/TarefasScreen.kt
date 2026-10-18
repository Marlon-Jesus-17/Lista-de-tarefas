package com.example.listadetarefas

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import org.w3c.dom.Text

@Composable
fun TarefasScreen(
    modifier: Modifier = Modifier,
    viewModel: TarefasViewModel = viewModel()
){

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
                viewModel.adicionar(texto)
                texto = ""
            }
        ) {
            Text("Adicionar")
        }

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(viewModel.tarefas, key = {it.id}){ tarefa ->
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Checkbox(
                        checked = tarefa.concluida,
                        onCheckedChange = {
                            viewModel.alternarConcluida(tarefa.id)
                        }
                    )
                    Text(tarefa.titulo)

//                    TextButton(
//                        onClick = {
//                            viewModel.tarefas = viewModel.tarefas.filter {
//                                item -> item.id != tarefa.id
//                            }
//                        }
//                    ) {
//                        Text("Remover")
//                    }
                }
            }
        }

    }

}

@Composable
@Preview(showBackground = true)
fun TarefasScreenPreview(){
    TarefasScreen()
}