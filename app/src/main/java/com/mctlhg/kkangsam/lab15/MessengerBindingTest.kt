package com.mctlhg.kkangsam.lab15

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.os.Message
import android.os.Messenger
import android.util.Log
import com.mctlhg.kkangsam.R
import com.mctlhg.kkangsam.databinding.ActivityBindServiceTestBinding
import com.mctlhg.kkangsam.databinding.ActivityMessengerBindingTestBinding

class MessengerBindingTest : AppCompatActivity() {
    lateinit var messenger: Messenger
    val connection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            messenger = Messenger(service)
        }
        override fun onServiceDisconnected(name: ComponentName?) {
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_messenger_binding_test)

        val binding = ActivityMessengerBindingTestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = Intent(this, MyService3::class.java)
        bindService(intent, connection, Context.BIND_AUTO_CREATE)

        binding.button1.setOnClickListener {
            val bundle=Bundle()
            bundle.putString("data1", "hello")
            bundle.putInt("data2", 10)

            val msg=Message()
            msg.what=10
            msg.obj=bundle
            messenger.send(msg)
        }
        binding.button2.setOnClickListener {
            val bundle=Bundle()
            bundle.putString("data1", "sunday")
            bundle.putInt("data2", 20)

            val msg=Message()
            msg.what=20
            msg.obj=bundle
            messenger.send(msg)
        }
        binding.button3.setOnClickListener {
            val bundle=Bundle()
            val msg=Message()
            msg.what=-1
            msg.obj=bundle
            messenger.send(msg)
        }
    }
}