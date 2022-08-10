package com.mctlhg.kkangsam.lab10

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.DatePicker
import android.widget.TimePicker
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.mctlhg.kkangsam.R
import com.mctlhg.kkangsam.databinding.ActivityToastDateTimePickerBinding

class ToastDateTimePicker : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_toast_date_time_picker)

        val binding = ActivityToastDateTimePickerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button1.setOnClickListener {
            val toast = Toast.makeText(this, "종료하려면 한번 더 누르세요.. ", Toast.LENGTH_SHORT)
            toast.addCallback(
                object : Toast.Callback() {
                    override fun onToastHidden() {
                        super.onToastHidden()
                        Log.d("kkangtest", "toast hidden")
                    }

                    override fun onToastShown() {
                        super.onToastShown()
                        Log.d("kkangtest", "toast show..")
                    }
                }
            )
            toast.show()
        }

        binding.button2.setOnClickListener {
            DatePickerDialog(this, object: DatePickerDialog.OnDateSetListener{
                override fun onDateSet(p0: DatePicker?, p1: Int, p2: Int, p3: Int) {
                    Log.d("kkangtest","date: $p1, $p2, $p3")
                }
            }, 2022, 10, 3).show()
        }

        binding.button3.setOnClickListener {
            TimePickerDialog(this, object : TimePickerDialog.OnTimeSetListener{
                override fun onTimeSet(p0: TimePicker?, p1: Int, p2: Int) {
                    Log.d("kkangtest", "time : $p1, $p2")
                }
            }, 15, 0, true).show()
        }
    }
}