package com.mctlhg.kkangsam.lab14

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MyReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        Toast.makeText(context, "receiver...", Toast.LENGTH_SHORT).show()
    }
}