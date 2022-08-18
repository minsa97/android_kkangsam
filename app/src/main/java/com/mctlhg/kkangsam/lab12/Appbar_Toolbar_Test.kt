package com.mctlhg.kkangsam.lab12

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import com.mctlhg.kkangsam.R
import com.mctlhg.kkangsam.databinding.ActivityAppbarToolbarTestBinding

class Appbar_Toolbar_Test : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_appbar_toolbar_test)
        val binding = ActivityAppbarToolbarTestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_test, menu)
        return super.onCreateOptionsMenu(menu)
    }
}