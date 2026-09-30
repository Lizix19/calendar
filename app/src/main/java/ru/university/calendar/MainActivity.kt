package ru.university.calendar

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val tag = "Lifecycle"
    private lateinit var database: AppDatabase
    private lateinit var adapter: TaskAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        database = AppDatabase.getDatabase(this)

        val recyclerView: RecyclerView = findViewById(R.id.tasksRecyclerView)
        adapter = TaskAdapter(emptyList()) { task ->
            val intent = Intent(this, TaskDetailActivity::class.java)
            intent.putExtra("TASK_ID", task.id)
            startActivity(intent)
        }
        recyclerView.adapter = adapter

        val addTaskFab = findViewById<com.google.android.material.floatingactionbutton.FloatingActionButton>(R.id.addTaskFab)
        addTaskFab.setOnClickListener {
            val intent = Intent(this, AddTaskActivity::class.java)
            startActivity(intent)
        }

        Log.d(tag, "onCreate")
    }

    override fun onResume() {
        super.onResume()
        loadTasksFromDatabase()
        Log.d(tag, "onResume")
    }

    private fun loadTasksFromDatabase() {
        lifecycleScope.launch {
            val tasksFromDb = database.taskDao().getAllTasks()
            adapter.updateTasks(tasksFromDb)
            Log.d("RoomTest", "Загружено задач из базы: ${tasksFromDb.size}")
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(tag, "onStart")
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