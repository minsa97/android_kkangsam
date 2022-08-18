package com.mctlhg.kkangsam.lab12

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import com.mctlhg.kkangsam.R
import com.mctlhg.kkangsam.databinding.ActivityMaterialProjectTestBinding
import com.mctlhg.kkangsam.lab11.*

class MaterialProjectTest : AppCompatActivity() {
    lateinit var toggle: ActionBarDrawerToggle

    class MyFragmentPagerAdapter(activity: FragmentActivity): FragmentStateAdapter(activity){
        val fragments: List<Fragment>
        init {
            //fragments= listOf(OneFragment(), TwoFragment(), ThreeFragment())
            fragments= listOf(PrjOneFragment(), PrjTwoFragment(), PrjThreeFragment())
        }
        override fun getItemCount(): Int = fragments.size

        override fun createFragment(position: Int): Fragment = fragments[position]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_material_project_test)

        val binding = ActivityMaterialProjectTestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //add......................................
        setSupportActionBar(binding.toolbar)
        toggle = ActionBarDrawerToggle(this, binding.drawer, R.string.drawer_opened, R.string.drawer_closed)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toggle.syncState()

        val adapter = MyFragmentPagerAdapter(this)
        binding.viewpager.adapter = adapter
        TabLayoutMediator(binding.tabs, binding.viewpager){ tab, position ->
            tab.text = "Tab${(position + 1)}"
        }.attach()

        binding.mainDrawerView.setNavigationItemSelectedListener{
            Log.d("kkangtest","navigation item click... ${it.title}")
            true
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //이벤트가 toggle 버튼에서 제공된거라면..
        if(toggle.onOptionsItemSelected(item)){
            Log.d("kkangtest","onOptionsItemSelected()")
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}