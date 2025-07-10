# 📝 TaskMaster

**TaskMaster** es una aplicación móvil de gestión de tareas, sencilla pero poderosa, desarrollada en **Kotlin** con **Jetpack Compose**, siguiendo la arquitectura **MVVM**. Ideal para organizar tus pendientes diarios con una interfaz elegante, moderna y fluida.

---

## Funcionalidades principales

✅ Agregar nuevas tareas  
✅ Editar tareas tocándolas  
✅ Marcar tareas como completadas (tachado automático)  
✅ Eliminar tareas fácilmente  
✅ Interfaz limpia con colores pastel y diseño responsivo  
✅ Botón flotante para agregar tareas  
✅ Compatible desde Android 5.0 (API 21)

---

## Tecnologías utilizadas

-  **Lenguaje:** Kotlin  
-  **UI:** Jetpack Compose + Material 3  
-  **Arquitectura:** MVVM (Model - ViewModel - View)  
-  **Estado:** mutableStateOf + State Hoisting  
-  **Entorno:** Android Studio

---

## Estructura del proyecto
com.example.taskmaster
┣  model
┃ ┗  Task.kt
┣  viewmodel
┃ ┗  TaskViewModel.kt
┣  ui.theme
┃ ┣  MainScreen.kt
┃ ┣  Theme.kt
┗  MainActivity.kt

##  ¿Cómo ejecutarlo?

### Opción 1: Desde Android Studio

   1. Clona el repositorio:
git clone https://github.com/Tsade-Parra/TaskMaster.git
   2.-Abre el proyecto en Android Studio.
   3.-Conecta tu emulador o dispositivo Android.
   4.-Haz clic en Run y ¡listo!

### Opción 2: Instalar el APK
  
   1.-Abre la carpeta:
app/build/outputs/apk/debug/
   2.-Copia app-debug.apk a tu celular.
   3.-Activa “Instalar desde fuentes desconocidas”.
   4.-Instálalo y comienza a organizar tus tareas.
   ---

## ¿Cómo se usa la app una vez instalada?

1. **Abrir la app TaskMaster**  
   Al iniciar, verás la pantalla principal con el título “My Tasks” y tu espacio de trabajo.

2. **Agregar una nueva tarea**  
   Pulsa el botón flotante “+” en la parte inferior derecha.  
   Se abrirá un campo de texto: escribe el nombre de tu tarea y pulsa **“Agregar”**.

3. **Marcar una tarea como completada**  
   Toca el **checkbox** junto a la tarea.  
   Verás que el texto se **subraya** y cambia a un color más tenue.

4. **Editar una tarea**  
   Toca el **texto de una tarea existente**.  
   Su contenido se cargará en el campo de entrada. Modifícalo y pulsa **“Guardar”**.

5. **Eliminar una tarea**  
   Pulsa el **ícono de bote de basura** a la derecha de la tarea que deseas borrar.

6. **Interfaz responsiva**  
   Funciona perfectamente tanto en pantallas pequeñas como grandes, con desplazamiento fluido y colores suaves.

 ### Requerimientos
  -Android Studio Flamingo o superior
  -SDK mínimo: API 21 (Android 5.0)
  -Kotlin 1.9+

  ### Créditos
  -Desarrollado por Brenda Parra 💖
  -Proyecto académico: App “TaskMaster”
  -Hecho con amor, dedicación y Kotlin 

  
