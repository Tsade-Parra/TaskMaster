package com.example.taskmaster.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.taskmaster.model.Task
import java.time.LocalDate

class TaskViewModel : ViewModel() {

    // Lista observable de tareas (estado de la UI)
    private val _tasks = mutableStateListOf<Task>()
    val tasks: List<Task> get() = _tasks

    private var nextId = 0 // Para asignar IDs únicos

    // Agrega una nueva tarea
    fun addTask(title: String)
    {
        if (title.isNotBlank()) {
            _tasks.add(Task(id = nextId++, title = title))
        }
    }

    // Cambia el estado de completado de una tarea
    fun toggleTaskDone(task: Task) {
        val index = _tasks.indexOf(task)
        if (index != -1) {
            _tasks[index] = _tasks[index].copy(isDone = !_tasks[index].isDone)
        }
    }

    // Elimina una tarea
    fun removeTask(task: Task) {
        _tasks.remove(task)
    }

    // Actualiza el título de una tarea
    fun updateTask(task: Task, newTitle: String) {
        val index = _tasks.indexOf(task)
        if (index != -1) {
            _tasks[index] = _tasks[index].copy(title = newTitle)
        }
    }
}
