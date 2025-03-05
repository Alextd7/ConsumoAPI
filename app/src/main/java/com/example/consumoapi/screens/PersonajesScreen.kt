package com.example.consumoapi.screens

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale

import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.consumoapi.model.Personaje

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PersonajesScreen(
    viewModel: PersonajesViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    Log.d("Cant. items", "${state.size}")

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Personajes Rick and Morty")}
            )
        }
    ) { paddingValues ->
        LazyColumn(
            contentPadding = paddingValues
        ) {
            items(state) { personaje ->
                PersonajeCard(personaje)
            }
        }
    }
}



@Composable
fun PersonajeCard(personaje: Personaje,
                  modifier: Modifier = Modifier
)
{
    Card(
        shape = MaterialTheme.shapes.medium,
             modifier = modifier.fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 4.dp))
    {

        Column {
            Row {
                Surface (
                    modifier.size(120.dp),
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.2f))
                {
                    AsyncImage(

                        model = personaje.image,
                        contentDescription = personaje.name,
                        contentScale = ContentScale.FillBounds
                    )

                  }

                Column(modifier.padding(16.dp)
                    .align(Alignment.CenterVertically)
                    .weight(1f)
                ) {
                    Text(text= personaje.name,
                        style = MaterialTheme.typography.titleLarge

                    )

                }


            }

        }

    }

}
