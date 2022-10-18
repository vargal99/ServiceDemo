package com.example.android.servicedemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.android.servicedemo.MyBackGroundService.Companion.MARKS
import com.example.android.servicedemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val serviceIntent = Intent(this, MyBackGroundService::class.java)

        //Logcat -> Info -> write "MYTAG"
        serviceIntent.putExtra(MyBackGroundService.NAME, "Alex")
        serviceIntent.putExtra(MARKS, "10")
        binding.btnStart.setOnClickListener {
            Log.i(MyBackGroundService.TAG,"Starting service")
            startService(serviceIntent)
            Toast.makeText(this, "Look at Logcat!", Toast.LENGTH_SHORT).show()

        }
        binding.btnStop.setOnClickListener {
            Log.i(MyBackGroundService.TAG,"Stop service")
            stopService(serviceIntent)
            Toast.makeText(this, "Look at Logcat!", Toast.LENGTH_SHORT).show()

        }
    }
}