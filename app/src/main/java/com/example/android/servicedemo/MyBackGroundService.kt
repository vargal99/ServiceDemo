package com.example.android.servicedemo

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import java.security.Provider

class MyBackGroundService : Service() {

    init {
        Log.i(TAG, "Service has been created")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.i(TAG, "Service started")
        val name = intent?.getStringExtra(NAME)
        val marks = intent?.getIntExtra(MARKS, 0)
        Log.i(TAG, "name is $name, marks is $marks")
        return START_STICKY
    }


    override fun onBind(p0: Intent?): IBinder? = null

    override fun onDestroy() {
        Log.i(TAG,"Destroying...")
        super.onDestroy()
    }

    companion object{
        const val TAG = "MYTAG"
        const val NAME = "NAME"
        const val MARKS = "TOTAL MARKS"
    }
}
