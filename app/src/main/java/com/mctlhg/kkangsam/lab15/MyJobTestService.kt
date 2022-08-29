package com.mctlhg.kkangsam.lab15

import android.app.Service
import android.app.job.JobParameters
import android.app.job.JobService
import android.content.Intent
import android.os.IBinder
import android.os.SystemClock
import android.util.Log

class MyJobTestService : JobService() {

    override fun onCreate() {
        super.onCreate()
        Log.d("kkangtest","JobService...onCreate....")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("kkangtest","JobService...onDestroy....")
    }

    override fun onStartJob(p0: JobParameters?): Boolean {
        val param = p0?.extras?.getString("extra_data")
        Log.d("kkangtest","JobService...onStartJob....$param...")

        Thread(Runnable {
            var sum =0
            for(i in 1..3){
                sum += i
                SystemClock.sleep(1000)
            }

            Log.d("kkangtest","JobService...onStartJob..thread  $sum..")
            jobFinished(p0, false)
        }).start()

        return true
    }

    override fun onStopJob(p0: JobParameters?): Boolean {
        Log.d("kkangtest","JobService...onStopJob....")
        return false
    }
}