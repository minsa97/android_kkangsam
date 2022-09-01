package com.mctlhg.ch15_service

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.app.job.JobParameters
import android.app.job.JobService
import android.content.Intent
import android.os.Build
import android.os.IBinder

class MyJobService : JobService() {
    override fun onStartJob(p0: JobParameters?): Boolean {
        val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val channel = NotificationChannel(
                "oneId",
                "oneName",
                NotificationManager.IMPORTANCE_DEFAULT)

            channel.description="oneDesc"
            manager?.createNotificationChannel(channel)
            Notification.Builder(this, "oneId")

        }else {
            Notification.Builder(this)
        }.run {
            setSmallIcon(android.R.drawable.ic_notification_overlay)
            setContentText("Content Message")
            setContentTitle("JobScheduler Title")
            setAutoCancel(true)
            manager?.notify(1, build())
        }
        return false
    }

    override fun onStopJob(p0: JobParameters?): Boolean {
        return true
    }
}