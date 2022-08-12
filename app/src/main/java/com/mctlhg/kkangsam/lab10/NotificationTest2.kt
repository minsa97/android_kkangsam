package com.mctlhg.kkangsam.lab10

import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import androidx.core.app.Person
import androidx.core.graphics.drawable.IconCompat
import com.mctlhg.kkangsam.R
import com.mctlhg.kkangsam.databinding.ActivityNotificationTest2Binding

class NotificationTest2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_notification_test2)

        val binding = ActivityNotificationTest2Binding.inflate(layoutInflater)
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
            }
            else {
                builder = NotificationCompat.Builder(this)
            }

            builder.setSmallIcon(android.R.drawable.ic_notification_overlay)
            builder.setWhen(System.currentTimeMillis())
            builder.setContentTitle("Title")
            builder.setContentText("TEXT")

            val person1 = Person.Builder()
                .setName("kkang")
                .setIcon(IconCompat.createWithResource(this, R.drawable.person1))
                .build()

            val person2 = Person.Builder()
                .setName("kim")
                .setIcon(IconCompat.createWithResource(this, R.drawable.person2))
                .build()

            val message1 = NotificationCompat.MessagingStyle.Message(
                "hello",
                System.currentTimeMillis(),
                person1
            )
            val message2 = NotificationCompat.MessagingStyle.Message(
                "world",
                System.currentTimeMillis(),
                person2
            )

            val messageStyle = NotificationCompat.MessagingStyle(person1)
                .addMessage(message1)
                .addMessage(message2)

            builder.setStyle(messageStyle)

            manager.notify(11, builder.build())
        }
    }
}