package com.mctlhg.kkangsam.lab13

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.mctlhg.kkangsam.R
import com.mctlhg.kkangsam.databinding.ActivityCoroutineTestBinding
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.consumeEach
import kotlin.system.measureNanoTime

class Coroutine_Test : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_coroutine_test)

        val binding = ActivityCoroutineTestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            /*var sum = 0L
            var time = measureNanoTime {
                for(i in 1..2_000_000_000){
                    sum += i
                }

                for(i in 1..2_000_000_000){
                    sum += i
                }

                for(i in 1..2_000_000_000){
                    sum += i
                }
            }
            Log.d("kkangtest", "time: $time")
            binding.textView.text="sum : $sum"*/

            val channel = Channel<Int>()

            val scope = CoroutineScope(Dispatchers.Default + Job())
            scope.launch {
                var sum = 0L
                var time = measureNanoTime {
                    for(i in 1..2_000_000_000){
                        sum += i
                    }

                    for(i in 1..2_000_000_000){
                        sum += i
                    }

                    for(i in 1..2_000_000_000){
                        sum += i
                    }
                }
                channel.send(sum.toInt())
            }

            val mainScope = GlobalScope.launch(Dispatchers.Main) {
                channel.consumeEach {
                    binding.textView.text = "sum : $it"
                }
            }
        }
    }
}