package com.mctlhg.kkangsam.lab11

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mctlhg.kkangsam.databinding.FragmentThreeBinding

class ThreeFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentThreeBinding.inflate(inflater, container, false)
        return binding.root
    }


}