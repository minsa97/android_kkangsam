package com.mctlhg.kkangsam.lab10

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import com.mctlhg.kkangsam.R
import com.mctlhg.kkangsam.databinding.ActivityAlertDialogTestBinding
import com.mctlhg.kkangsam.databinding.DialogInputBinding

class AlertDialogTest : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_alert_dialog_test)

        val binding = ActivityAlertDialogTestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button1.setOnClickListener {
            val items = arrayOf("사과","복숭아","수박")
            AlertDialog.Builder(this).run {
                setTitle("items test")
                setIcon(android.R.drawable.ic_dialog_alert)
                setMultiChoiceItems(
                    items,
                    booleanArrayOf(true, false, true),
                    object : DialogInterface.OnMultiChoiceClickListener {
                        override fun onClick(p0: DialogInterface?, p1: Int, p2: Boolean) {
                            Log.d("kkangtest","${items[p1]} 이 ${if(p2) "선택되었습니다." else "선택 해제되었습니다."}")

                        }
                    }
                )
                setPositiveButton("닫기", null)
                show()
            }

        }
        binding.button2.setOnClickListener {
            val dialogBinding = DialogInputBinding.inflate(layoutInflater)
            AlertDialog.Builder(this).run {
                setTitle("input")
                setView(dialogBinding.root)
                setPositiveButton("닫기", null)
                show()
            }
        }
    }
}