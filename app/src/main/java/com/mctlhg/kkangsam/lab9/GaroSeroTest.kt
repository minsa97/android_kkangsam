package com.mctlhg.kkangsam.lab9

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.mctlhg.kkangsam.R

class GaroSeroTest : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_garo_sero_test)
        Log.d("test", "onCreate()")
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        Log.d("test", "onConfigurationChanged()")
        if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            // 가로 방향
        } else if(newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            // 세로 방향
        }
    }
}
