package ru.university.calendar

class TaskRepository(private val taskDao: TaskDao) {

    suspend fun getAllTasks(): List<Task> {
        return taskDao.getAllTasks()

    }

    suspend fun getTasksByDate(date: String): List<Task> {
        return taskDao.getTasksByDate(date)
    }

    suspend fun addTask(task: Task) {
        taskDao.insertTask(task)
    }

    suspend fun updateTask(task: Task) {
        taskDao.updateTask(task)
    }

    suspend fun deleteTask(task: Task) {
        taskDao.deleteTask(task)
    }
}