package com.mctlhg.kkangsam.lab13

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mctlhg.kkangsam.R
import com.mctlhg.kkangsam.databinding.ActivitySaveStateTestBinding

class SaveActivityState_Test : AppCompatActivity() {
    var count = 0
    lateinit var binding : ActivitySaveStateTestBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_save_state_test)

        binding = ActivitySaveStateTestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.countButton.setOnClickListener {
            count++
            binding.resultView.text = "$count"
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("count", count)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val data = savedInstanceState.getInt("count")
        binding.resultView.text = "$data"
        count= data
    }
}