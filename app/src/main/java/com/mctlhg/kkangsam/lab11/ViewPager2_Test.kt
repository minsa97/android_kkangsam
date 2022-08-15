package com.mctlhg.kkangsam.lab11

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mctlhg.kkangsam.R
import com.mctlhg.kkangsam.databinding.ActivityRecyclerviewTestBinding
import com.mctlhg.kkangsam.databinding.ActivityViewPager2TestBinding
import com.mctlhg.kkangsam.databinding.ItemBinding
import com.mctlhg.kkangsam.databinding.ItemPagerBinding

class ViewPager2_Test : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_view_pager2_test)
        val binding = ActivityViewPager2TestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = mutableListOf<Int>()
        for(i in 0..2){
            data.add(i)
        }

        binding.viewpager.adapter = MyPagerAdapter(data)
    }
}

class MyPagerAdapter(val data: MutableList<Int>): RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    inner class MyPagerViewHolder(val binding: ItemPagerBinding): RecyclerView.ViewHolder(binding.root)

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MyPagerViewHolder(
            ItemPagerBinding.inflate(
            LayoutInflater.from(parent.context), parent,
            false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding = (holder as MyPagerViewHolder).binding
        binding.itemData.text = "ITEM "+data[position].toString()
        when(position%3){
            0->binding.backgroundlayout.setBackgroundColor(Color.RED)
            1->{
                binding.backgroundlayout.setBackgroundColor(Color.BLUE)
                binding.itemData.setTextColor(Color.WHITE)
            }
            2->binding.backgroundlayout.setBackgroundColor(Color.GREEN)
        }
    }
}
