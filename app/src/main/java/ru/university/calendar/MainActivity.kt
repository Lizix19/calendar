package ru.university.calendar

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val tag = "Lifecycle"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val tasks = listOf(
            Task(1, "Купить продукты", "Молоко, хлеб, яйца", "05.10.2026"),
            Task(2, "Сдать лабораторную работу", "Курс по Android", "07.10.2026", isDone = true),
            Task(3, "Подготовиться к поездке в Питер", "Повторить лекции 1-5", "12.10.2026"),
            Task(4, "Сходить в йогу", "День ног", "06.10.2026")
        )

        val recyclerView: RecyclerView = findViewById(R.id.tasksRecyclerView)
        recyclerView.adapter = TaskAdapter(tasks) { task ->
            val intent = Intent(this, TaskDetailActivity::class.java)
            intent.putExtra("TASK_ID", task.id)
            startActivity(intent)
        }

        val addTaskFab = findViewById<com.google.android.material.floatingactionbutton.FloatingActionButton>(R.id.addTaskFab)
        addTaskFab.setOnClickListener {
            val intent = Intent(this, AddTaskActivity::class.java)
            startActivity(intent)
        }

        Log.d(tag, "onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.d(tag, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(tag, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(tag, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(tag, "onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(tag, "onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(tag, "onDestroy")
    }
}