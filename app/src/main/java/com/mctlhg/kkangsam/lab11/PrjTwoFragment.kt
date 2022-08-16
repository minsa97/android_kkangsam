package com.mctlhg.kkangsam.lab11

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mctlhg.kkangsam.databinding.FragmentPrjTwoBinding

class PrjTwoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentPrjTwoBinding.inflate(inflater, container, false).root
    }

}