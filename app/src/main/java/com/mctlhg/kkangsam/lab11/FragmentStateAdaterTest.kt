package com.mctlhg.kkangsam.lab11

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.mctlhg.kkangsam.R
import com.mctlhg.kkangsam.databinding.ActivityFragmentStateAdaterTestBinding

class FragmentStateAdaterTest : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_fragment_state_adater_test)

        val binding = ActivityFragmentStateAdaterTestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.viewpager.adapter = MyFragmentPagerAdapter(this)
    }
}


class MyFragmentPagerAdapter(actiivty: FragmentActivity): FragmentStateAdapter(actiivty){
    val fragments: List<Fragment>
    init {
        fragments = listOf(OneFragment(), TwoFragment(), ThreeFragment())
    }

    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }
}
