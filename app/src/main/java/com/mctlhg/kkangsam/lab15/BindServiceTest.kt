package com.mctlhg.kkangsam.lab15

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import com.mctlhg.kkangsam.R
import com.mctlhg.kkangsam.databinding.ActivityBindServiceTestBinding

class BindServiceTest : AppCompatActivity() {
    lateinit var serviceBinder: MyService2.MyBinder
    val connection = object : ServiceConnection {
        override fun onServiceConnected(p0: ComponentName?, p1: IBinder?) {
            serviceBinder = p1 as MyService2.MyBinder
        }
        override fun onServiceDisconnected(p0: ComponentName?) {
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_bind_service_test)

        val binding = ActivityBindServiceTestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = Intent(this, MyService2::class.java)
        bindService(intent, connection, Context.BIND_AUTO_CREATE)

        binding.button1.setOnClickListener {
            serviceBinder.funA(10)
        }
        binding.button2.setOnClickListener {
            Log.d("kkangtest", "${serviceBinder.funB(20)}")
        }
    }
}