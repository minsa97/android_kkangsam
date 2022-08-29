package com.mctlhg.kkangsam.lab15

import android.app.job.JobInfo
import android.app.job.JobScheduler
import android.content.ComponentName
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import com.mctlhg.kkangsam.R
import com.mctlhg.kkangsam.databinding.ActivityJobSchedulerTestBinding

class JobSchedulerTest : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_job_scheduler_test)

        val binding = ActivityJobSchedulerTestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            val scheduler = getSystemService(JOB_SCHEDULER_SERVICE) as JobScheduler

            val extras = PersistableBundle()
            extras.putString("extra_data","hello kkang")

            val builder = JobInfo.Builder(1, ComponentName(this, MyJobTestService::class.java))
            builder.setRequiredNetworkType(JobInfo.NETWORK_TYPE_UNMETERED)
            builder.setExtras(extras)

            scheduler.schedule(builder.build())
        }
    }
}