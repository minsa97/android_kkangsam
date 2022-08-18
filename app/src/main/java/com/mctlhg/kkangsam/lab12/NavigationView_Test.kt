package com.mctlhg.kkangsam.lab12

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.mctlhg.kkangsam.R
import com.mctlhg.kkangsam.databinding.ActivityAppbarToolbarTestBinding
import com.mctlhg.kkangsam.databinding.ActivityNavigationViewTestBinding

class NavigationView_Test : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_navigation_view_test)

        val binding = ActivityNavigationViewTestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.mainDrawerView.setNavigationItemSelectedListener{
            Log.d("kkangtest","navigation item click... ${it.title}")
            true
        }
    }
}