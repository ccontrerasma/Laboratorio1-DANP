package com.example.myfirstapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myfirstapp.ui.theme.MyFirstAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyFirstAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ListaTareas(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
@Composable
fun PantallaUtilizable(){
    var mensaje by remember { mutableStateOf("") }

    Column {

        Text(text = "Bienvenidosss")

        Text(text = "Al Primer Laboratorio")

        Button(onClick = {
            mensaje = "Vamos aprender juntos"
        }) {
            Text(text = "Presionar")
        }

        Text(text = mensaje)
    }
}
@Composable
fun ListaTareas(modifier: Modifier = Modifier) {

    val tareas = listOf(
        "Estudiar Compose" to "Aprender cómo funcionan los composables",
        "Hacer ejercicio" to "Salir a caminar 30 minutos",
        "Comprar comida" to "Comprar pan, leche y frutas",
        "Hacer tarea" to "Terminar el ejercicio de Android"
    )
    LazyColumn(modifier = modifier.padding(16.dp)) {

        items(tareas) { tarea ->

            ItemCard(
                titulo = tarea.first,
                descripcion = tarea.second
            )
        }
    }
}
@Composable
fun ItemCard(
    titulo: String,
    descripcion: String
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 12.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = titulo)
            Text(text = descripcion)
        }
    }
}