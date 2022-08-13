package com.mctlhg.kkangsam.lab8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.CompoundButton
import com.mctlhg.kkangsam.R
import com.mctlhg.kkangsam.databinding.ActivityCheckboxTestBinding
import com.mctlhg.kkangsam.databinding.ActivityTest2Binding

class Checkbox_Test : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_checkbox_test)
        val binding = ActivityCheckboxTestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            Log.d("kkang", "button click...")
        }
//        binding.checkView.setOnCheckedChangeListener(MyHandler())
//        binding.checkView.setOnCheckedChangeListener(object : CompoundButton.OnCheckedChangeListener{
//            override fun onCheckedChanged(p0: CompoundButton?, p1: Boolean) {
//                Log.d("kkang", "check click... $p1")
//            }
//        })

        binding.checkView.setOnCheckedChangeListener {  p0: CompoundButton?, p1: Boolean->
            Log.d("kkang", "check click... $p1")
        }

    }
}

//class MyHandler : CompoundButton.OnCheckedChangeListener {
//    override fun onCheckedChanged(p0: CompoundButton?, p1: Boolean) {
//        Log.d("kkang", "check click... $p1")
//    }
//}