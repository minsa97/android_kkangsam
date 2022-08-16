package com.mctlhg.kkangsam.lab11

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mctlhg.kkangsam.databinding.FragmentPrjThreeBinding

class PrjThreeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return return FragmentPrjThreeBinding.inflate(inflater, container, false).root
    }
}