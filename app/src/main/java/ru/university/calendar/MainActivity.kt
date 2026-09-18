package ru.university.calendar

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.util.Log

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

        Log.d(tag, "onCreate")
        demoKotlinBasics()
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

    private fun demoKotlinBasics() {
        val appName = "Calendar"       // val: значение менять нельзя
        var tasksCount = 4             // var: значение менять можно
        tasksCount = tasksCount + 1

        val note: String? = null       // знак ? означает, что здесь может быть null

        Log.d("KotlinDemo", "appName=$appName, tasksCount=$tasksCount")
        Log.d("KotlinDemo", "length: ${note?.length}")           // безопасный вызов ?.
        Log.d("KotlinDemo", "length or 0: ${note?.length ?: 0}") // оператор elvis ?:
    }
}