package com.mctlhg.kkangsam.lab11

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mctlhg.kkangsam.R
import com.mctlhg.kkangsam.databinding.ActivityFragmentTestBinding

class FragmentTest : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_fragment_test)

        val binding = ActivityFragmentTestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragment = OneFragment()
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()

        transaction.add(R.id.fragment_content, fragment)

        transaction.commit()
    }
}