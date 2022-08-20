package com.mctlhg.kkangsam.lab13

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mctlhg.kkangsam.R
import com.mctlhg.kkangsam.databinding.ActivityIntent02TestBinding

class Intent02_Test : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent02_test)

        val binding = ActivityIntent02TestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button1.setOnClickListener {
            //val intent = Intent()
            //intent.action = "ACTION_VIEW"
            //intent.data = Uri.parse("http://www.google.com")
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"))
            startActivity(intent)
        }

        binding.button2.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("geo:37.77,127.41"))
            intent.setPackage("com.google.android.apps.maps")
            startActivity(intent)
        }
    }
}