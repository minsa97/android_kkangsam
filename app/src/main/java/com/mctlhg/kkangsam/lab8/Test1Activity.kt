package com.mctlhg.kkangsam.lab8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.MotionEvent
import com.mctlhg.kkangsam.R

class Test1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test3)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when(event?.action){
            MotionEvent.ACTION_DOWN -> {
                Log.d("kkang", "touch down x: ${event.x}, rawX: ${event.rawX}")
            }
            MotionEvent.ACTION_UP -> {
                Log.d("kkang", "touch up")
            }
        }
        return super.onTouchEvent(event)
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        when(keyCode){
            KeyEvent.KEYCODE_BACK -> Log.d("kkang", "back button click...")
            KeyEvent.KEYCODE_VOLUME_UP -> Log.d("kkang", "volume up click...")
            KeyEvent.KEYCODE_VOLUME_DOWN -> Log.d("kkang", "volume down click...")
        }
        return super.onKeyDown(keyCode, event)
    }
}