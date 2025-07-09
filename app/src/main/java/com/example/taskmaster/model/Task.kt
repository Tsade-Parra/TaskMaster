package com.example.taskmaster.model

import java.time.LocalDate

// Modelo de datos para representar una tarea

    data class Task(
    val id: Int,
    val title: String,
    var isDone: Boolean = false
)

