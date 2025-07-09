package com.example.taskmaster.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.taskmaster.model.Task
import com.example.taskmaster.viewmodel.TaskViewModel

@Composable
fun MainScreen(viewModel: TaskViewModel) {
    var taskText by remember { mutableStateOf("") }
    var showInput by remember { mutableStateOf(false) }
    var editingTask by remember { mutableStateOf<Task?>(null) }

    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
            TopBar()

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "My Tasks",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )

            Text(
                text = "Aquí te recuerdo tus tareas/actividades",
                fontSize = 14.sp,
                color = Color.Gray,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(16.dp))

            if (showInput) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    TextField(
                        value = taskText,
                        onValueChange = { taskText = it },
                        placeholder = { Text("Escribe aquí tu tarea…") },
                        modifier = Modifier.weight(1f),
                        keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Button(onClick = {
                        if (taskText.isNotBlank()) {
                            editingTask?.let {
                                viewModel.updateTask(it, taskText)
                            } ?: run {
                                viewModel.addTask(taskText)
                            }
                            taskText = ""
                            editingTask = null
                            showInput = false
                        }
                    }) {
                        Text(if (editingTask != null) "Guardar" else "Agregar")
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
            }

            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(viewModel.tasks.size) { index ->
                    val task = viewModel.tasks[index]
                    TaskRow(task = task, onToggle = {
                        viewModel.toggleTaskDone(task)
                    }, onDelete = {
                        viewModel.removeTask(task)
                    }, onEdit = {
                        taskText = it.title
                        editingTask = it
                        showInput = true
                    })
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }

        FloatingActionButton(
            onClick = {
                showInput = true
                editingTask = null
                taskText = ""
            },
            containerColor = Color(0xFFF48FB1),
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(bottom = 72.dp, end = 16.dp)
        ) {
            Icon(Icons.Default.Add, contentDescription = "Agregar tarea", tint = Color.White)
        }
    }
}

@Composable
fun TopBar() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(36.dp)
                .clip(CircleShape)
                .background(Color.LightGray)
        )

        Row {
            IconButton(onClick = { }) {
                Icon(Icons.Default.Notifications, contentDescription = "Notificaciones")
            }
            IconButton(onClick = { }) {
                Icon(Icons.Default.Search, contentDescription = "Buscar")
            }
            IconButton(onClick = { }) {
                Icon(Icons.Default.Email, contentDescription = "Correo")
            }
        }
    }
}

@Composable
fun TaskRow(task: Task, onToggle: () -> Unit, onDelete: () -> Unit, onEdit: (Task) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onEdit(task) },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(checked = task.isDone, onCheckedChange = { onToggle() })
            Text(
                text = task.title,
                modifier = Modifier.padding(start = 8.dp),
                textDecoration = if (task.isDone) androidx.compose.ui.text.style.TextDecoration.LineThrough else null
            )
        }
        IconButton(onClick = { onDelete() }) {
            Icon(Icons.Default.Delete, contentDescription = "Eliminar")
        }
    }
}
