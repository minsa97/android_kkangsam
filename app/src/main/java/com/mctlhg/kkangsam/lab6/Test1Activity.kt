package com.mctlhg.kkangsam.lab6

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.mctlhg.kkangsam.R

class Test1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_test1)

        // 이름,문자열 출력 TextView 생성
        val name= TextView(this).apply{
            typeface= Typeface.DEFAULT_BOLD
            text="Lake Luise"
        }
        // 이미지 출력 ImageView 생성
        val image= ImageView(this).also{
            it.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.lake_1))
        }
        // 주소 문자열 출력 TextView 생성
        val address= TextView(this).apply{
            typeface= Typeface.DEFAULT_BOLD
            text="Lake Louise, AB, 캐나다"
        }
        val layout= LinearLayout(this).apply{
            orientation= LinearLayout.VERTICAL
            gravity= Gravity.CENTER

            addView(name, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            addView(image, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            addView(address,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
        }
        // LinearLayout 객체를 화면에 출력
        setContentView(layout)
    }
}