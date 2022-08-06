package com.mctlhg.kkangsam.lab6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.mctlhg.kkangsam.R
import com.mctlhg.kkangsam.databinding.ActivityTest6Binding

class Test6Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_test6)
        val binding = ActivityTest6Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.visibleBtn.setOnClickListener {
            binding.targetView.visibility = View.VISIBLE
        }
        binding.invisibleBtn.setOnClickListener {
            binding.targetView.visibility = View.INVISIBLE
        }
    }
}