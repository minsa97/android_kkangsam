package com.mctlhg.kkangsam.lab15

import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.*
import android.widget.Toast

class MyService3 : Service() {
    lateinit var messenger: Messenger
    internal class IncomingHandler(
        context:Context,
        private val applicationContext: Context=context.applicationContext
    ): Handler(Looper.getMainLooper()){
        override fun handleMessage(msg: Message) {
            when(msg.what){
                10-> Toast.makeText(applicationContext, "${msg.obj}",Toast.LENGTH_SHORT).show()
                20-> Toast.makeText(applicationContext, "${msg.obj}",Toast.LENGTH_SHORT).show()
                else->{
                    Toast.makeText(applicationContext, "else",Toast.LENGTH_SHORT).show()
                    super.handleMessage(msg)
                }
            }
        }
    }
    override fun onBind(intent: Intent): IBinder {
        messenger=Messenger(IncomingHandler(this))
        return messenger.binder
    }
}