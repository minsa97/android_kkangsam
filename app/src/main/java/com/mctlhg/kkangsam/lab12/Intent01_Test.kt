package com.mctlhg.kkangsam.lab12

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.mctlhg.kkangsam.R
import com.mctlhg.kkangsam.databinding.ActivityIntent01TestBinding

class Intent01_Test : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_intent01_test)

        val binding = ActivityIntent01TestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val requestLauncher: ActivityResultLauncher<Intent> = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()){

            val resultData = it.data?.getStringExtra("result")
            binding.resultView.text = "result : $resultData"
        }

        binding.button.setOnClickListener {
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("data1", "hello")
            intent.putExtra("data2", 10)
            requestLauncher.launch(intent)
        }
    }
}