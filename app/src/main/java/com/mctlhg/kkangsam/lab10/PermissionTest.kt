package com.mctlhg.kkangsam.lab10

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import com.mctlhg.kkangsam.R

class PermissionTest : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_permission_test)

        val requestLauncher = registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ){  isGranted ->
            if(isGranted){
                Log.d("kkangtest", "callback... granted...")
            }else {
                Log.d("kkangtest", "callback... denied...")
            }
        }

        val status = ContextCompat.checkSelfPermission(this,
            "android.permission.ACCESS_FINE_LOCATION")
        if(status == PackageManager.PERMISSION_GRANTED){
            Log.d("kkangtest", "granted....")
        }else {
            Log.d("kkangtest", "requestLauncher....")
            requestLauncher.launch("android.permission.ACCESS_FINE_LOCATION")
        }
    }
}