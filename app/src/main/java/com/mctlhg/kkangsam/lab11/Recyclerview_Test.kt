package com.mctlhg.kkangsam.lab11

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.*
import com.mctlhg.kkangsam.R
import com.mctlhg.kkangsam.databinding.ActivityRecyclerviewTestBinding
import com.mctlhg.kkangsam.databinding.ItemBinding

class Recyclerview_Test : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_recyclerview_test)
        val binding = ActivityRecyclerviewTestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = mutableListOf<String>()
        for(i in 1..10){
            data.add("Item $i")
        }

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = MyAdapter(data)
        binding.recyclerView.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))

    }
}

class MyViewHolder(val binding: ItemBinding): ViewHolder(binding.root)

class MyAdapter(val data: MutableList<String>): Adapter<ViewHolder>(){
    override fun getItemCount(): Int {
        return data.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return MyViewHolder(ItemBinding.inflate(
            LayoutInflater.from(parent.context), parent,
            false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val binding = (holder as MyViewHolder).binding
        binding.itemData.text = data[position]
    }
}