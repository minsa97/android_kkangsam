package com.mctlhg.kkangsam.lab10

import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import com.mctlhg.kkangsam.R
import com.mctlhg.kkangsam.databinding.ActivityNotificationTestBinding

class NotificationTest : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_notification_test)

        val binding = ActivityNotificationTestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            val builder : NotificationCompat.Builder

            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
                val channel = NotificationChannel("one", "one chanenl",
                    NotificationManager.IMPORTANCE_LOW)
                channel.description="one description"

                manager.createNotificationChannel(channel)

                builder =  NotificationCompat.Builder(this, "one")
            }else {
                builder = NotificationCompat.Builder(this)
            }

            builder.setSmallIcon(android.R.drawable.ic_notification_overlay)
            builder.setWhen(System.currentTimeMillis())
            builder.setContentTitle("Title")
            builder.setContentText("TEXT")

            manager.notify(11, builder.build())
        }
    }
}